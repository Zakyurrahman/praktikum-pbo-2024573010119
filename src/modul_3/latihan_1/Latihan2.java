package modul_3.latihan_1;

import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Langkah 1: Deklarasi array 2D untuk nilai siswa (5 siswa, 4 mata pelajaran)
        String[] namaSiswa = {"A", "B", "C", "D", "E"};
        String[] mataPelajaran = {"Matematika", "Bahasa Indonesia", "IPA", "IPS"};
        int[][] nilaiSiswa = new int[5][4];
        // Langkah 2: Input nilai
        System.out.println("=== INPUT NILAI SISWA ===");
        for (int i = 0; i < namaSiswa.length; i++) {
            System.out.println("Masukkan nilai untuk " + namaSiswa[i] + ":");
            for (int j = 0; j < mataPelajaran.length; j++) {
                System.out.print(mataPelajaran[j] + ": ");
                nilaiSiswa[i][j] = input.nextInt();
            }
            System.out.println();
        }
        // Langkah 3: Menampilkan data dalam bentuk tabel
        System.out.println("=== TABEL NILAI SISWA ===");
        System.out.printf("%-10s", "Nama");
        for (String mapel : mataPelajaran) {
            System.out.printf("%-8s", mapel.substring(0, Math.min(7, mapel.length())));
        }
        System.out.printf("%-8s%-8s%-20s\n", "Total", "Rata2", "Nilai Tertinggi (Mapel)");
        for (int i = 0; i < namaSiswa.length; i++) {
            System.out.printf("%-10s", namaSiswa[i]);
            int total = 0;
            int nilaiTertinggi = nilaiSiswa[i][0];
            String mapelTertinggi = mataPelajaran[0];
            for (int j = 0; j < mataPelajaran.length; j++) {
                System.out.printf("%-8d", nilaiSiswa[i][j]);
                total += nilaiSiswa[i][j];
                if (nilaiSiswa[i][j] > nilaiTertinggi) {
                    nilaiTertinggi = nilaiSiswa[i][j];
                    mapelTertinggi = mataPelajaran[j];
                }
            }
            double rataRata = total / (double) mataPelajaran.length;
            System.out.printf("%-8d%-8.2f%-20s\n", total, rataRata, mapelTertinggi);
        }
        // Langkah 4: Menghitung rata-rata tiap mata pelajaran
        System.out.println("\n=== RATA-RATA PER MATA PELAJARAN ===");
        for (int j = 0; j < mataPelajaran.length; j++) {
            int totalMapel = 0;
            for (int i = 0; i < namaSiswa.length; i++) {
                totalMapel += nilaiSiswa[i][j];
            }
            double rataMapel = totalMapel / (double) namaSiswa.length;
            System.out.printf("%-20s : %.2f\n", mataPelajaran[j], rataMapel);
        }
    }
}

