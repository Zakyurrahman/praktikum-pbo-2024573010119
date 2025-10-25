package modul_5.praktikum_1;

public class Person {
    //Private - hanya bisa diakses dalam ini
    private String nama;
    private int umur;

// Default (package-private) - bisa diakses dalam package yang sama
    String alamat;

// protected - bisa diakses dalam package dan subclass
    protected String telepon;
//public - bisa diakses dimana saja
    public String email;

    //Constructor
    public Person(String nama,int umur){
        this.nama= nama;
        this.umur= umur;
    }

    //Public method untuk menampilkan info
    public void tampilkanInfo(){
        System.out.println("INFORMASI PERSON");
        System.out.println("Nama     :" + nama);
        System.out.println("Umur     :"  + umur);
        System.out.println("Alamat   :"  + alamat);
        System.out.println("Telepon   :"  + telepon);
        System.out.println("Email      :"  + email);
    }

//Private method - hanya  bisa dipanggil dalam class ini
    private void metodePribadi(){
        System.out.println("ini adalah method private");
    }

    //Protected method
    protected void metodeProtected(){
        System.out.println("ini adalah method private");
    }

    //Method untuk mengakses private method
    public void panggilMetodePribadi(){
        metodePribadi();
    }

}

