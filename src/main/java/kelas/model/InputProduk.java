package kelas.model;

public class InputProduk {

    private final String kode;
    private final Produk produk;

    public InputProduk(String kode, Produk produk) {
        if (kode == null || kode.isBlank() || produk == null) {
            throw new IllegalArgumentException("Data produk tidak lengkap.");
        }
        this.kode = kode;
        this.produk = produk;
    }

    public String getKode() {
        return kode;
    }

    public Produk getProduk() {
        return produk;
    }

    public String getJenis() {
        if (produk instanceof ProdukMinuman) {
            return "Minuman";
        } else {
            return "Makanan";
        }
    }

    public String getNamaProduk() {
        return produk.getNamaProduk();
    }

    public int getHarga() {
        return produk.getHarga();
    }
}
