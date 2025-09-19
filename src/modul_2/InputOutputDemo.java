package modul_2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class InputOutputDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Nama Anda: ");
        String nama = input.nextLine();

        System.out.println("Masukkan Umur Anda: ");
        int umur = input.nextInt();

        System.out.println("Masukkan Tinggi Anda (cm): ");
        double tinggi = input.nextDouble();

        System.out.println("DATA ANDA");
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + "tahun");
        System.out.println("Tinggi: " + tinggi + "cm" );


        input.close();
    }
}
