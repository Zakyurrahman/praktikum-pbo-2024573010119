package modul_2;

import java.util.Scanner;

public class GradeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukka Nilai (0-100): ");
        int nilai = input.nextInt();

        char grade;
        String keterangan;

        if(nilai >= 85) {
            grade = 'A';
            keterangan = "Excelent";
        }else if (nilai >= 75){
            grade = 'B';
            keterangan ="Good";
        }else if (nilai >= 65){
            grade = 'C';
            keterangan ="Fair";
        }else if (nilai >= 55){
            grade = 'D';
            keterangan = "Poor";
        }else {
            grade = 'E';
            keterangan ="Fail";
        }

        System.out.println("Nilai: " + nilai);
        System.out.println("Grade: " + grade);
        System.out.println("Keterangan: "+ keterangan);

        input.close();

    }
}