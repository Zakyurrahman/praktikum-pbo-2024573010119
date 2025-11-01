package modul_4;

public class TugasKartuRencanaStudi {
    private Mahasiswa mahasiswa;
    private MataKuliah[] daftarMatakuliah;
    private int jumlahMatkul;
    private int maxMatkul;
    private final int BATAS_SKS = 24; // batas maksimum total SKS

    // Konstruktor
    public TugasKartuRencanaStudi(Mahasiswa mahasiswa, int maxMatkul) {
        this.mahasiswa = mahasiswa;
        this.maxMatkul = maxMatkul;
        this.daftarMatakuliah = new MataKuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    // Menambah mata kuliah ke KRS dengan validasi batas SKS
    public boolean tambahMatakuliah(MataKuliah matkul) {
        int totalSKSSementara = hitungTotalSKS() + matkul.getSks();

        if (totalSKSSementara > BATAS_SKS) {
            System.out.println("\nTidak dapat menambahkan " + matkul.getNama() +
                    " karena total SKS akan melebihi batas " + BATAS_SKS + " SKS!");
            return false;
        }

        if (jumlahMatkul < maxMatkul) {
            daftarMatakuliah[jumlahMatkul] = matkul;
            jumlahMatkul++;
            System.out.println("\nMata kuliah " + matkul.getNama() + " berhasil ditambahkan!");
            return true;
        } else {
            System.out.println("\nKRS sudah penuh! Maksimal " + maxMatkul + " mata kuliah.");
            return false;
        }
    }

    // Menghapus mata kuliah berdasarkan kode
    public boolean hapusMatakuliah(String kode) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                System.out.println("\nMata kuliah " + daftarMatakuliah[i].getNama() + " berhasil dihapus dari KRS!");
                // Geser elemen setelahnya ke kiri
                for (int j = i; j < jumlahMatkul - 1; j++) {
                    daftarMatakuliah[j] = daftarMatakuliah[j + 1];
                }
                daftarMatakuliah[jumlahMatkul - 1] = null;
                jumlahMatkul--;
                return true;
            }
        }
        System.out.println("\nMata kuliah dengan kode " + kode + " tidak ditemukan!");
        return false;
    }

    // Menghitung total SKS
    public int hitungTotalSKS() {
        int totalSKS = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            totalSKS += daftarMatakuliah[i].getSks();
        }
        return totalSKS;
    }

    // Menghitung IPK
    public double hitungIPK() {
        if (jumlahMatkul == 0) return 0.0;

        double totalBobot = 0.0;
        int totalSKS = 0;

        for (int i = 0; i < jumlahMatkul; i++) {
            MataKuliah mk = daftarMatakuliah[i];
            totalBobot += mk.getNilai() * mk.getSks();
            totalSKS += mk.getSks();
        }

        return totalSKS > 0 ? totalBobot / totalSKS : 0.0;
    }

    // Menampilkan mata kuliah dengan nilai terbaik
    public void tampilkanMatkulTerbaik() {
        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah di KRS.");
            return;
        }
        MataKuliah terbaik = daftarMatakuliah[0];
        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() > terbaik.getNilai()) {
                terbaik = daftarMatakuliah[i];
            }
        }
        System.out.println("\nMata kuliah dengan nilai terbaik:");
        terbaik.tampilkanInfo();
    }

    // Menampilkan mata kuliah dengan nilai terburuk
    public void tampilkanMatkulTerburuk() {
        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah di KRS.");
            return;
        }
        MataKuliah terburuk = daftarMatakuliah[0];
        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() < terburuk.getNilai()) {
                terburuk = daftarMatakuliah[i];
            }
        }
        System.out.println("\nMata kuliah dengan nilai terburuk:");
        terburuk.tampilkanInfo();
    }

    // Menampilkan KRS
    public void tampilkanKRS() {
        System.out.println("----------------------------------------------------------");
        System.out.println("\t\tKARTU RENCANA STUDI (KRS)");
        System.out.println("----------------------------------------------------------");
        System.out.println("Nama Mahasiswa : " + mahasiswa.getNama());
        System.out.println("NPM            : " + mahasiswa.getNim());
        System.out.println("Jurusan        : " + mahasiswa.getJurusan());
        System.out.println("----------------------------------------------------------");
        System.out.println("KODE\tMATA KULIAH\t\tSKS\tNILAI");
        System.out.println("----------------------------------------------------------");

        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (int i = 0; i < jumlahMatkul; i++) {
                daftarMatakuliah[i].tampilkanInfo();
            }
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total SKS   : " + hitungTotalSKS());
        System.out.printf("IPK Semester: %.2f\n", hitungIPK());
        System.out.println("----------------------------------------------------------\n");
    }

    // Mencari mata kuliah berdasarkan kode
    public MataKuliah cariMatakuliah(String kode) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                return daftarMatakuliah[i];
            }
        }
        return null;
    }
}

