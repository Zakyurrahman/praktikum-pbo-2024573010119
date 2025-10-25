package modul_3.latihan_1;

public class Latihan1 {
    public static void main(String[] args) {
        // Deklarasi dan inisialisasi array nilai ujian 10 siswa
        int[] nilai = {82, 70, 90, 87, 98, 50, 89, 73, 95, 83};
        // Menampilkan semua nilai
        System.out.println("Daftar Nilai Ujian 10 Siswa:");
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Siswa ke-" + (i + 1) + " : " + nilai[i]);
        }
        // Menghitung total nilai
        int total = 0;
        for (int n : nilai) {
            total += n;
        }
        // Menghitung rata-rata
        double rataRata = (double) total / nilai.length;
        // Mencari nilai tertinggi dan terendah
        int nilaiTertinggi = nilai[0];
        int nilaiTerendah = nilai[0];
        for (int i = 1; i < nilai.length; i++) {
            if (nilai[i] > nilaiTertinggi) {
                nilaiTertinggi = nilai[i];
            }
            if (nilai[i] < nilaiTerendah) {
                nilaiTerendah = nilai[i];
            }
        }
        // Menampilkan hasil akhir
        System.out.println("\n=== Hasil Analisis Nilai Ujian ===");
        System.out.println("Rata-rata Nilai : " + rataRata);
        System.out.println("Nilai Tertinggi : " + nilaiTertinggi);
        System.out.println("Nilai Terendah : " + nilaiTerendah);
    }
}
