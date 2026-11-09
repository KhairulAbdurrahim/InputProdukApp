package kelas.controller;

import java.io.IOException;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.InputProduk;

public class DaftarController {

    @FXML
    private TableView<InputProduk> tabel;
    @FXML
    private TableColumn<InputProduk, String> kodeCol;
    @FXML
    private TableColumn<InputProduk, String> produkCol;
    @FXML
    private TableColumn<InputProduk, String> jenisCol;
    @FXML
    private TableColumn<InputProduk, Integer> hargaCol; // Kolom harga di FXML
    @FXML
    private TextField cariField;
    @FXML
    private ComboBox<String> filterJenisBox;
    @FXML
    private CheckBox totalCheck;
    @FXML
    private CheckBox hargaCheck;
    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;
    private final ObservableList<InputProduk> dataTampilan = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // KOLOM KODE
        kodeCol.setCellValueFactory(new PropertyValueFactory<>("kode"));

        // KOLOM NAMA PRODUK
        produkCol.setCellValueFactory(new PropertyValueFactory<>("namaProduk"));

        // KOLOM JENIS
        jenisCol.setCellValueFactory(new PropertyValueFactory<>("jenis"));

        // KOLOM HARGA
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga"));

        filterJenisBox.getItems().addAll("Semua", "Makanan", "Minuman");
        filterJenisBox.setValue("Semua");

        tabel.setItems(dataTampilan);
        tabel.setPlaceholder(new Label("Belum ada data yang sesuai."));
        ubahTampilanHarga();
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        cari();
    }

    @FXML
    private void cari() {
        if (data == null) {
            return;
        }
        dataTampilan.clear();
        String kata = cariField.getText().trim().toLowerCase(Locale.ROOT);
        String jenisDipilih = filterJenisBox.getValue();

        for (InputProduk produk : data.getDaftar()) {
            String kode = produk.getKode().toLowerCase(Locale.ROOT);
            String nama = produk.getNamaProduk().toLowerCase(Locale.ROOT);
            boolean cocokKata = kode.contains(kata) || nama.contains(kata);
            boolean cocokJenis = "Semua".equals(jenisDipilih) || produk.getJenis().equalsIgnoreCase(jenisDipilih);

            if (cocokKata && cocokJenis) {
                dataTampilan.add(produk);
            }
        }
        tabel.sort();
        pesanLabel.setText("Jumlah data yang tampil: " + dataTampilan.size());
    }

    @FXML
    private void resetPencarian() {
        cariField.clear();
        filterJenisBox.setValue("Semua");
        cari();
    }

    @FXML
    private void ubahTampilanHarga() {
        if (hargaCheck != null && hargaCol != null) {
            hargaCol.setVisible(hargaCheck.isSelected());
        }
    }

    @FXML
    private void tambah() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Form gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {
        InputProduk produk = tabel.getSelectionModel().getSelectedItem();
        if (produk == null) {
            pesanLabel.setText("Pilih satu baris dahulu.");
            return;
        }
        try {
            navigator.bukaDetail(produk);
        } catch (IOException e) {
            pesanLabel.setText("Detail gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void hapus() {
        InputProduk produk = tabel.getSelectionModel().getSelectedItem();
        if (produk == null) {
            pesanLabel.setText("Pilih satu baris dahulu.");
            return;
        }
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION,
                "Hapus " + produk.getKode() + "?",
                ButtonType.YES, ButtonType.NO);
        dialog.initOwner(tabel.getScene().getWindow());
        ButtonType jawaban = dialog.showAndWait().orElse(ButtonType.NO);
        if (jawaban == ButtonType.YES) {
            data.hapus(produk);
            cari();
        }
    }
}