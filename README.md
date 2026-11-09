# Aplikasi Pencatatan Produk - JavaFX (MVC Pattern)

Aplikasi desktop berbasis JavaFX untuk manajemen pencatatan data produk (Makanan dan Minuman) yang dikembangkan menggunakan arsitektur **Model-View-Controller (MVC)**, file tata letak **FXML**, styling **CSS**, dan manajemen *build* menggunakan **Maven**.

---

## Fitur Utama
* **Arsitektur MVC:** Pemisahan yang jelas antara logika data (`Model`), antarmuka pengguna (`View`/FXML), dan pengendali aktivitas program (`Controller`).
* **Form Input & Validasi:** Form untuk memasukkan nama produk, memilih kategori, dan menginput harga dengan validasi data yang ketat.
* **Tabel Data Produk:** Menampilkan daftar seluruh produk secara dinamis lengkap dengan kolom kode produk otomatis, nama, kategori, dan harga.
* **Pencarian & Filter:** Memudahkan pencarian produk berdasarkan nama/kode serta menyaring data berdasarkan kategori.
* **Halaman Detail Produk:** Menampilkan informasi lengkap dan spesifik dari produk yang dipilih.

---

## Teknologi & Tools
* **Java**
* **JavaFX** (GUI Framework & FXML)
* **CSS** (Custom Styling untuk antarmuka)
* **Apache Maven** (Build & Dependency Management)
* **NetBeans IDE**
* **Git & GitHub**

---

## Cara Menjalankan Aplikasi

### Melalui NetBeans IDE
1. Pastikan Anda sudah mengunduh/meng-clone repository ini ke komputer lokal.
2. Buka **NetBeans IDE**, lalu pilih **File > Open Project**.
3. Cari dan pilih folder project `InputProdukApp` tempat file `pom.xml` berada, lalu klik **Open Project**.
4. Tunggu beberapa saat hingga NetBeans selesai memuat seluruh *Dependencies* Maven.
5. Lakukan **Clean and Build** pada project jika diperlukan.
6. Perluas struktur project ke `src/main/java/kelas/MainApp.java`, klik kanan pada file tersebut, lalu pilih **Run File** (atau tekan `Shift + F6`). Aplikasi JavaFX akan terbuka secara otomatis.

---

## Dokumentasi Tampilan Aplikasi

Berikut adalah beberapa pratinjau tampilan dari aplikasi Pencatatan Produk:

### 1. Tampilan Awal / Form Input
![Tampilan Awal](gambar/Tampilan%20Awal.png)

### 2. Proses Pengisian Data
![Pengisian Tampilan Awal](gambar/Pengisian%20Tampilan%20Awal.png)

### 3. Tampilan Daftar Produk (Kosong)
![Tampilan Daftar Kosong](gambar/Tampilan%20Daftar%20(kosong).png)

### 4. Tampilan Daftar Produk (Dengan Data)
![Tampilan Daftar 3 Item](gambar/Tampilan%20Daftar%20(3%20item).png)

### 5. Tampilan Detail Produk
![Tampilan Detail](gambar/Tampilan%20Detail.png)
