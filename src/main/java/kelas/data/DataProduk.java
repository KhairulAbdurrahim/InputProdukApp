package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.InputProduk;
import kelas.model.Produk;

public class DataProduk {

    private final ObservableList<InputProduk> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<InputProduk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public InputProduk tambah(Produk produk) {
        //TR%03d  Bagian ini digunakan untuk membuat kode pembelian, misalnya TR001, TR002, dan seterusnya.
        InputProduk p = new InputProduk(String.format("TR%03d", urutan), produk);
        daftar.add(p);
        urutan++;
        return p;
    }

    public void hapus(InputProduk p) {
        daftar.remove(p);
    }
}
