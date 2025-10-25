package modul_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("------------------------------------------------");
    System.out.println("           SISTEM KARTU RENCANA STUDI (KRS)     ");
    System.out.println("------------------------------------------------");

    // Input data mahasiswa
    System.out.print("Nama Mahasiswa: ");
    String nama = input.nextLine();

    System.out.print("NIM: ");
    String nim = input.nextLine();

    System.out.print("Jurusan: ");
    String jurusan = input.nextLine();

    // Membuat object mahasiswa
    Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan, 0.0);

    // Membuat object KRS (maksimal 10 mata kuliah, batas SKS = 24)
    KartuRencanaStudi krs = new KartuRencanaStudi(mhs, 10, 24);

    boolean running = true;

    while (running) {
        System.out.println("------------------------------------------------");
        System.out.println("|                  MENU KRS                    |");
        System.out.println("------------------------------------------------");
        System.out.println("| 1. Tambah Mata Kuliah                        |");
        System.out.println("| 2. Input Nilai Mata Kuliah                   |");
        System.out.println("| 3. Hapus Mata Kuliah                         |");
        System.out.println("| 4. Tampilkan KRS                             |");
        System.out.println("| 5. Tampilkan Nilai Terbaik & Terburuk        |");
        System.out.println("| 6. Keluar                                    |");
        System.out.println("------------------------------------------------");
        System.out.print("Pilih menu: ");

        int pilihan = input.nextInt();
        input.nextLine(); // consume newline

        switch (pilihan) {
            case 1:
                // Tambah mata kuliah
                System.out.println("\nTAMBAH MATA KULIAH");
                System.out.println("--------------------");
                System.out.print("Kode Mata Kuliah: ");
                String kode = input.nextLine();

                System.out.print("Nama Mata Kuliah: ");
                String namaMK = input.nextLine();

                System.out.print("Jumlah SKS: ");
                int sks = input.nextInt();
                input.nextLine();

                MataKuliah mk = new MataKuliah(kode, namaMK, sks);
                krs.tambahMatakuliah(mk);
                break;

            case 2:
                // Input nilai
                System.out.println("\nINPUT NILAI");
                System.out.println("--------------------");
                System.out.print("Masukkan kode mata kuliah: ");
                String kodeNilai = input.nextLine();
                System.out.print("Masukkan nilai (0-100): ");
                double nilai = input.nextDouble();
                input.nextLine();
                krs.inputNilai(kodeNilai, nilai);
                break;

            case 3:
                // Hapus mata kuliah
                System.out.println("\nHAPUS MATA KULIAH");
                System.out.println("--------------------");
                System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
                String kodeHapus = input.nextLine();
                krs.hapusMatakuliah(kodeHapus);
                break;

            case 4:
                // Tampilkan KRS
                krs.tampilkanKRS();
                break;

            case 5:
                // Tampilkan terbaik & terburuk
                krs.tampilkanTerbaikDanTerburuk();
                break;

            case 6:
                running = false;
                System.out.println("Keluar dari program...");
                break;

            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }
    input.close();
}
}

