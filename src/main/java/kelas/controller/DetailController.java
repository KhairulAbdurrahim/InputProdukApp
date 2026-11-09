package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.InputProduk;

public class DetailController {

    @FXML
    private Label kodeLabel, produkLabel, jenisLabel, hargaLabel, totalLabel, pesanLabel;
    
    private Navigator navigator;

    public void setData(Navigator navigator, InputProduk p) {
        this.navigator = navigator;
        kodeLabel.setText(p.getKode());
        produkLabel.setText(p.getNamaProduk());
        jenisLabel.setText(p.getJenis());
        
        String formatHarga = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID")).format(p.getHarga());
        hargaLabel.setText(String.valueOf(p.getHarga()));
        totalLabel.setText(formatHarga);
    }

    @FXML
    private void tambahLagi() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form.");
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