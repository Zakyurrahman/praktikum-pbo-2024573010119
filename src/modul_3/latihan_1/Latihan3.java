package modul_3.latihan_1;

public class Latihan3 {
    // Langkah 1: Method void tanpa parameter
    public static void tampilkanHeader() {
        System.out.println("==================================");
        System.out.println(" PROGRAM KALKULATOR SEDERHANA");
        System.out.println("==================================");
    }
    // Langkah 2: Method void dengan parameter
    public static void tampilkanHasil(String operasi, double a, double b, double hasil) {
        System.out.printf("%.2f %s %.2f = %.2f\n", a, operasi, b, hasil);
    }
    // Overload untuk hasil satu operand (misal akar kuadrat)
    public static void tampilkanHasil(String operasi, double a, double hasil) {
        System.out.printf("%s(%.2f) = %.2f\n", operasi, a, hasil);
    }
    // Langkah 3: Method dengan return value (operasi dasar)
    public static double tambah(double a, double b) {
        return a + b;
    }
    public static double kurang(double a, double b) {
        return a - b;
    }
    public static double kali(double a, double b) {
        return a * b;
    }
    public static double bagi(double a, double b) {
        if (validasiPembagian(b)) {
            return a / b;
        } else {
            System.out.println("Error: Pembagian dengan nol tidak diperbolehkan!");
            return 0;
        }
    }
    // Tambahan: Method pangkat dan akar kuadrat
    public static double pangkat(double a, double b) {
        return Math.pow(a, b);
    }
    public static double akarKuadrat(double a) {
        if (a < 0) {
            System.out.println("Error: Tidak dapat menghitung akar dari bilangan negatif!");
            return 0;
        }
        return Math.sqrt(a);
    }
    // Langkah 4: Validasi input umum
    public static boolean validasiAngka(double angka) {
        return !Double.isNaN(angka) && Double.isFinite(angka);
    }
    // Tambahan: Validasi pembagian dengan nol
    public static boolean validasiPembagian(double pembagi) {
        return pembagi != 0;
    }
    // Langkah 5: Main method (penggunaan semua method)
    public static void main(String[] args) {
        tampilkanHeader();
        double x = 15;
        double y = 10;
        if (validasiAngka(x) && validasiAngka(y)) {
            double hasilTambah = tambah(x, y);
            double hasilKurang = kurang(x, y);
            double hasilKali = kali(x, y);
            double hasilBagi = bagi(x, y);
            double hasilPangkat = pangkat(x, y);
            double hasilAkar = akarKuadrat(x);
            tampilkanHasil("+", x, y, hasilTambah);
            tampilkanHasil("-", x, y, hasilKurang);
            tampilkanHasil("*", x, y, hasilKali);
            tampilkanHasil("/", x, y, hasilBagi);
            tampilkanHasil("^", x, y, hasilPangkat);
            tampilkanHasil("√", x, hasilAkar);
        } else {
            System.out.println("Input tidak valid.");
        }
    }
}

