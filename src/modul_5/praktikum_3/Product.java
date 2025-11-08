package modul_5.praktikum_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    // Read-only (hanya getter)
    private final String productId;
    private final LocalDateTime createdAt;

    // Read-write (getter dan setter)
    private String nama;
    private double harga;
    private int stok;

    // Write-only (hanya setter) - untuk password/PIN
    private String adminPin;

    // Computed property (tidak ada attribute, hanya getter)
    // Total nilai = harga * stok
    private static int counter = 1000;

    // CONSTRUCTOR
    public Product(String nama, double harga, int stok, String adminPin) {
        this.productId = generateProductId();
        this.createdAt = LocalDateTime.now();
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.adminPin = adminPin;
    }

    // PRIVATE HELPER METHODS
    private String generateProductId() {
        counter++;
        return "PRD-" + counter;
    }

    private boolean validatePin(String inputPin) {
        return this.adminPin.equals(inputPin);
    }

    // READ-ONLY PROPERTIES (hanya getter)
    public String getProductId() { return productId; }

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return createdAt.format(formatter);
    }

    // READ-WRITE PROPERTIES (getter dan setter)
    public String getNama() { return nama; }

    public void setNama(String nama, String pin) {
        if (!validatePin(pin)) {
            System.out.println("PIN salah! Gagal mengubah nama.");
            return;
        }
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama produk tidak boleh kosong!");
            return;
        }
        this.nama = nama;
        System.out.println("Nama produk berhasil diubah!");
    }

    public double getHarga() { return harga; }

    public void setHarga(double harga, String pin) {
        if (!validatePin(pin)) {
            System.out.println("PIN salah! Gagal mengubah harga.");
            return;
        }
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif!");
            return;
        }
        this.harga = harga;
        System.out.printf("Harga berhasil diubah menjadi Rp %.2f\n", harga);
    }

    public int getStok() { return stok; }

    public void setStok(int stok, String pin) {
        if (!validatePin(pin)) {
            System.out.println("PIN Anda salah! Gagal mengubah stok!");
            return;
        }
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }
        this.stok = stok;
        System.out.println("Stok berhasil diubah menjadi " + stok);
    }

    // WRITE-ONLY PROPERTY (hanya setter)
    public void changeAdminPin(String oldPin, String newPin) {
        if (!validatePin(oldPin)) {
            System.out.println("PIN lama salah!");
            return;
        }
        if (newPin.length() < 4) {
            System.out.println("PIN baru minimal 4 karakter!");
            return;
        }
        this.adminPin = newPin;
        System.out.println("PIN berhasil diubah");
    }

    // COMPUTED PROPERTIES (calculated on-the-fly)
    public double getTotalNilai() {
        return harga * stok;
    }

    public String getStatusStok() {
        if (stok == 0) return "HABIS";
        else if (stok < 10) return "MENIPIS";
        else if (stok < 50) return "TERSEDIA";
        else return "BANYAK";
    }

    // PUBLIC METHODS
    public boolean tambahStok(int jumlah, String pin) {
        if (!validatePin(pin)) {
            System.out.println("PIN salah!");
            return false;
        }
        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0!");
            return false;
        }
        stok += jumlah;
        System.out.printf("Stok ditambah %d. Stok sekarang: %d\n", jumlah, stok);
        return true;
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0!");
            return false;
        }
        if (jumlah > stok) {
            System.out.println("Stok tidak cukup!");
            System.out.printf("Stok tersedia: %d, Diminta: %d\n", stok, jumlah);
            return false;
        }
        stok -= jumlah;
        System.out.printf("Stok dikurangi %d. Stok sekarang: %d\n", jumlah, stok);
        if (stok < 10) {
            System.out.println("Peringatan: Stok mulai menipis!");
        }
        return true;
    }

    public void tampilkanInfo() {
        System.out.println("=== INFORMASI PRODUK ===");
        System.out.println("-----------------------------");
        System.out.println(" Produk ID   : " + productId);
        System.out.println(" Nama       : " + nama);
        System.out.printf(" Harga      : Rp %.2f\n", harga);
        System.out.println(" Stok: " + stok + " (" + getStatusStok() + ")");
        System.out.printf(" Total Nilai: Rp %.2f\n", getTotalNilai());
        System.out.println(" Dibuat pada: " + getCreatedAt());
        System.out.println("-----------------------------");
    }
}

