package modul_2;

import java.util.Scanner;

public class MenuDemo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("MENU PILIHAN");
        System.out.println("1. Hitung Luas persegi");
        System.out.println("2. Hitung Luas Lingkaran");
        System.out.println("3. Hitung Luas Segitiga");
        System.out.println("4. Keluar");

        System.out.print("Pilih menu (1-4): ");
        int pilihan = input.nextInt();

        switch(pilihan){
            case  1:
                System.out.println("Masukkan sisi persegi: ");
                double sisi = input.nextDouble();
                double luaspersegi =  sisi * sisi;
                System.out.println("Luas Persegi: " + luaspersegi);
                break;

            case 2:
                System.out.println("Masukkan jari-jari lingkaran: ");
                double jariJari = input.nextDouble();
                double luaslingkaran = Math.PI * jariJari * jariJari;
                System.out.println("Luas lingkaran: " + luaslingkaran);
                break;

            case 3:
                System.out.println("Masukkan alas segitiga: ");
                double alas = input.nextDouble();
                System.out.println("Masukkan tinggi segitiga: ");
                double tinggi = input.nextDouble();
                double luasSegitiga = 0.5 * alas * tinggi;
                System.out.println("Luas segitiga: "+ luasSegitiga);
                break;

            case 4:
                System.out.println("Terima Kasih");
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }

}
