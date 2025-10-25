package modul_3.latihan_1;

import java.util.Scanner;

public class Latihan5 {
    public static void analisisString(String teks) {
        System.out.println("\n=== ANALISIS STRING ===");
        System.out.println("Teks asli: \"" + teks + "\"");
        System.out.println("Panjang string: " + teks.length());
        System.out.println("Karakter pertama: " + teks.charAt(0));
        System.out.println("Karakter terakhir: " + teks.charAt(teks.length() - 1));
        System.out.println("Uppercase: " + teks.toUpperCase());
        System.out.println("lowercase: " + teks.toLowerCase());
// Menghitung jumlah kata
        String[] kata = teks.trim().split("\\s+");
        System.out.println("Jumlah kata: " + kata.length);
// Menghitung jumlah vokal dan konsonan
        int jumlahVokal = hitungVokal(teks);
        int jumlahKonsonan = hitungKonsonan(teks);
        System.out.println("Jumlah vokal: " + jumlahVokal);
        System.out.println("Jumlah konsonan: " + jumlahKonsonan);
    }
    public static int hitungVokal(String teks) {
        String vokal = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < teks.length(); i++) {
            if (vokal.contains(String.valueOf(teks.charAt(i)))) {
                count++;
            }
        }
        return count;
    }
    public static int hitungKonsonan(String teks) {
        String huruf = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String vokal = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < teks.length(); i++) {
            char c = teks.charAt(i);
            if (huruf.indexOf(c) != -1 && vokal.indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }
    public static String reverseString(String teks) {
        StringBuilder reversed = new StringBuilder();
        for (int i = teks.length() - 1; i >= 0; i--) {
            reversed.append(teks.charAt(i));
        }
        return reversed.toString();
    }
    public static boolean isPalindrome(String teks) {
        String clean = teks.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }
    public static String toPascalCase(String teks) {
        String[] kata = teks.trim().split("\\s+");
        StringBuilder hasil = new StringBuilder();
        for (String k : kata) {
            if (k.length() > 0) {
                hasil.append(Character.toUpperCase(k.charAt(0)));
                if (k.length() > 1) {
                    hasil.append(k.substring(1).toLowerCase());
                }
                hasil.append(" ");
            }
        }
        return hasil.toString().trim();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PROGRAM MANIPULASI STRING ===");
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine();
// Analisis dasar
        analisisString(kalimat);
// String terbalik
        System.out.println("\nString terbalik: \"" + reverseString(kalimat) + "\"");
// Cek Palindrom
        if (isPalindrome(kalimat)) {
            System.out.println("String ini adalah palindrom.");
        } else {
            System.out.println("String ini bukan palindrom.");
        }
// Pascal Case
        System.out.println("\nString dalam format Pascal Case: \"" + toPascalCase(kalimat) +
                "\"");
// Pencarian substring
        System.out.println("\nMasukkan kata yang ingin dicari:");
        String cari = input.nextLine();
        if (kalimat.toLowerCase().contains(cari.toLowerCase())) {
            System.out.println("Kata \"" + cari + "\" ditemukan dalam kalimat.");
            int posisi = kalimat.toLowerCase().indexOf(cari.toLowerCase());
            System.out.println("Posisi pertama: " + posisi);
        } else {
            System.out.println("Kata \"" + cari + "\" tidak ditemukan dalam kalimat.");
        }
    }
}

