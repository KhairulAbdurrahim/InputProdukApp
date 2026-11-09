package kelas.model;

public abstract class Produk {
    private final String namaProduk; 
    private final int harga;
 
 public Produk(String nama, int harga) {
    if(nama == null || nama.isBlank()) throw new IllegalArgumentException("Nama wajib diisi.");
    if(harga <= 0) throw new IllegalArgumentException("harga harus lebih dari nol.");
    this.namaProduk=nama.trim(); this.harga=harga;
 }
 public String getNamaProduk(){return namaProduk;}
 public int getHarga(){return harga;}
 
}
