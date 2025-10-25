package modul_4;

public class KartuRencanaStudi {
    private Mahasiswa mahasiswa;
    private MataKuliah[] daftarMatakuliah;
    private int jumlahMatkul;
    private int maxMatkul;
    private int batasSks;

    public KartuRencanaStudi(Mahasiswa mahasiswa, int maxMatkul, int batasSks) {
        this.mahasiswa = mahasiswa;
        this.maxMatkul = maxMatkul;
        this.batasSks = batasSks;
        this.daftarMatakuliah = new MataKuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    // Hitung total SKS
    public int totalSks() {
        int total = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            total += daftarMatakuliah[i].getSks();
        }
        return total;
    }

    // Tambah mata kuliah dengan validasi batas SKS
    public void tambahMatakuliah(MataKuliah mk) {
        if (jumlahMatkul >= maxMatkul) {
            System.out.println("KRS sudah penuh!");
            return;
        }

        if (totalSks() + mk.getSks() > batasSks) {
            System.out.println("Tidak dapat menambah mata kuliah. Total SKS melebihi batas " + batasSks + "!");
            return;
        }

        daftarMatakuliah[jumlahMatkul] = mk;
        jumlahMatkul++;
        System.out.println("Mata kuliah " + mk.getNama() + " berhasil ditambahkan!");
    }

    // Hapus mata kuliah berdasarkan kode
    public void hapusMatakuliah(String kode) {
        boolean found = false;
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                found = true;
                // Geser elemen setelahnya ke kiri
                for (int j = i; j < jumlahMatkul - 1; j++) {
                    daftarMatakuliah[j] = daftarMatakuliah[j + 1];
                }
                jumlahMatkul--;
                System.out.println("Mata kuliah dengan kode " + kode + " berhasil dihapus!");
                break;
            }
        }
        if (!found) {
            System.out.println("Mata kuliah dengan kode " + kode + " tidak ditemukan!");
        }
    }

    // Input nilai ke salah satu mata kuliah
    public void inputNilai(String kode, double nilai) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                daftarMatakuliah[i].setNilai(nilai);
                System.out.println("Nilai berhasil dimasukkan untuk mata kuliah " + daftarMatakuliah[i].getNama());
                return;
            }
        }
        System.out.println("Mata kuliah tidak ditemukan!");
    }

    // Tampilkan daftar KRS
    public void tampilkanKRS() {
        System.out.println("\n================== DAFTAR KRS ==================");
        System.out.println("Nama Mahasiswa : " + mahasiswa.getNama());
        System.out.println("NIM            : " + mahasiswa.getNim());
        System.out.println("Jurusan        : " + mahasiswa.getJurusan());
        System.out.println("-----------------------------------------------");

        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah yang diambil.");
            return;
        }

        for (int i = 0; i < jumlahMatkul; i++) {
            MataKuliah mk = daftarMatakuliah[i];
            System.out.println((i + 1) + ". " + mk.getKode() + " - " + mk.getNama() +
                    " (" + mk.getSks() + " SKS) | Nilai: " + mk.getNilai());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Total SKS: " + totalSks());
    }

    // Cari mata kuliah dengan nilai terbaik dan terburuk
    public void tampilkanTerbaikDanTerburuk() {
        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah dalam KRS.");
            return;
        }

        MataKuliah terbaik = daftarMatakuliah[0];
        MataKuliah terburuk = daftarMatakuliah[0];

        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() > terbaik.getNilai()) {
                terbaik = daftarMatakuliah[i];
            }
            if (daftarMatakuliah[i].getNilai() < terburuk.getNilai()) {
                terburuk = daftarMatakuliah[i];
            }
        }

        System.out.println("\n================= NILAI TERBAIK & TERBURUK =================");
        System.out.println("Mata Kuliah Terbaik : " + terbaik.getNama() + " (" + terbaik.getNilai() + ")");
        System.out.println("Mata Kuliah Terburuk: " + terburuk.getNama() + " (" + terburuk.getNilai() + ")");
    }
}


