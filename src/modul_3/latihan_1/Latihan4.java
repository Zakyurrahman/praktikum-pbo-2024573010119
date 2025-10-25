package modul_3.latihan_1;

import java.util.Scanner;

public class Latihan4 {
    // Method untuk meminta input array
    public static int[] inputArray(int ukuran) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[ukuran];
        System.out.println("Masukkan " + ukuran + " angka:");
        for (int i = 0; i < ukuran; i++) {
            System.out.print("Angka ke-" + (i + 1) + ": ");
            array[i] = input.nextInt();
        }
        return array;
    }
    // Method untuk menampilkan array
    public static void tampilkanArray(int[] array) {
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    // Method untuk mencari nilai maksimum
    public static int cariMaksimum(int[] array) {
        int maks = array[0]; // Asumsikan elemen pertama adalah yang terbesar
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maks) {
                maks = array[i];
            }
        }
        return maks;
    }
    // Method untuk mencari nilai minimum
    public static int cariMinimum(int[] array) {
        int min = array[0]; // Asumsikan elemen pertama adalah yang terkecil
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    // Method untuk menghitung rata-rata
    public static double hitungRataRata(int[] array) {
        int total = 0;
        for (int nilai : array) {
            total += nilai;
        }
        return (double) total / array.length;
    }
    // Method untuk mengurutkan array (Bubble Sort)
    public static int[] urutkanArray(int[] array) {
        int[] arrayBaru = array.clone();
        for (int i = 0; i < arrayBaru.length - 1; i++) {
            for (int j = 0; j < arrayBaru.length - 1 - i; j++) {
                if (arrayBaru[j] > arrayBaru[j + 1]) {
                    // Tukar posisi
                    int temp = arrayBaru[j];
                    arrayBaru[j] = arrayBaru[j + 1];
                    arrayBaru[j + 1] = temp;
                }
            }
        }
        return arrayBaru;
    }
    // 🔹 Method baru: mencari nilai tertentu dalam array
    public static boolean cariNilai(int[] array, int nilaiCari) {
        for (int nilai : array) {
            if (nilai == nilaiCari) {
                return true; // Nilai ditemukan
            }
        }
        return false; // Nilai tidak ditemukan
    }
    // 🔹 Method baru: menghitung median dari array yang sudah diurutkan
    public static double hitungMedian(int[] arrayUrut) {
        int panjang = arrayUrut.length;
        if (panjang % 2 == 1) {
            // Jika jumlah elemen ganjil, ambil elemen tengah
            return arrayUrut[panjang / 2];
        } else {
            // Jika genap, ambil rata-rata dari dua elemen tengah
            int tengahKiri = arrayUrut[(panjang / 2) - 1];
            int tengahKanan = arrayUrut[panjang / 2];
            return (tengahKiri + tengahKanan) / 2.0;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM ANALISIS ARRAY ===");
        int[] data = inputArray(5);
        System.out.println("\n=== HASIL ANALISIS ===");
        tampilkanArray(data);
        System.out.println("Nilai Maksimum : " + cariMaksimum(data));
        System.out.println("Nilai Minimum : " + cariMinimum(data));
        System.out.printf("Rata-rata : %.2f\n", hitungRataRata(data));
        int[] dataUrut = urutkanArray(data);
        System.out.print("Array setelah diurutkan: ");
        tampilkanArray(dataUrut);
        // 🔹 Cari nilai tertentu
        System.out.print("\nMasukkan nilai yang ingin dicari: ");
        int nilaiCari = input.nextInt();
        boolean ditemukan = cariNilai(data, nilaiCari);
        if (ditemukan) {
            System.out.println("Nilai " + nilaiCari + " ditemukan dalam array.");
        } else {
            System.out.println("Nilai " + nilaiCari + " tidak ditemukan dalam array.");
        }
        // 🔹 Hitung median
        double median = hitungMedian(dataUrut);
        System.out.printf("Median dari array: %.2f\n", median);
    }
}

