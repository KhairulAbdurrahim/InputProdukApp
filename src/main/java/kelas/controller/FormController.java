package kelas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.*;

public class FormController {

    @FXML
    private TextField produkField, hargaField;
    @FXML
    private ComboBox<String> jenisBox;
    @FXML
    private Label pesanLabel;
    
    private Navigator navigator;
    private DataProduk data;

    @FXML
    private void initialize() {
        jenisBox.getItems().addAll("Makanan", "Minuman");
        jenisBox.setValue("Makanan");
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void simpan() {
        InputProduk p;
        try {
            int harga = Integer.parseInt(hargaField.getText().trim());
            Produk produk;

            if ("Minuman".equals(jenisBox.getValue())) {
                produk = new ProdukMinuman(produkField.getText(), harga);
            } else {
                produk = new ProdukMakanan(produkField.getText(), harga);
            }
            p = data.tambah(produk);
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga harus berupa angka bulat positif.");
            return;
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
            return;
        }
        
        try {
            navigator.bukaDetail(p);
        } catch (IOException e) {
            data.hapus(p);
            pesanLabel.setText("Halaman detail gagal dibuka; data dibatalkan. Periksa FXML.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar.");
            e.printStackTrace();
        }
    }
}