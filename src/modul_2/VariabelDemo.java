package modul_2;

public class VariabelDemo {
    public static void main(String[] args) {
        int umur = 20;
        double tinggi = 175.5;
        char grade = 'A';
        boolean lulus= true;
        String nama = "Jhon Doe";

        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + " tahun");
        System.out.println("Tinggi: " + tinggi + "cm");
        System.out.println("Grade: " + grade);
        System.out.println("Lulus: " + lulus);

        int a = 10;
        int b = 3;

        System.out.println("Operasi Aritmatika");
        System.out.println("a =" + a);
        System.out.println("b =" + b);
        System.out.println("a + b =" + (a + b));
        System.out.println("a - b =" + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        System.out.println("Casting Tipe Data");
        double nilaiDouble = 9.8;
        int nilaiInt = (int) nilaiDouble;

        System.out.println("Nilai double: " + nilaiDouble);
        System.out.println("Setelah casting ke int: " + nilaiInt);

        byte byteVar = 50;
        short shortVar = 100;
        int hasil = byteVar + shortVar;
        System.out.println("byte + short = " + hasil + ("tipe: int"));
    }

}
