package modul_5.praktikum_1;

public class AccessModifierTest {
    public static void main(String[]args){
        Person Person = new Person("Budi Santoso",25);

        //Test akses public
        Person.email = "Budi@gmail.com";
        System.out.println("email:" + Person.email);

        //Test akses default (dalam package yang sama
        Person.alamat="jakarta";
        System.out.println("alamat:" + Person.alamat);

        //Test akses protected (dalam package yang sama)
        Person.telepon="087837236";
        System.out.println("Telepon:" + Person.telepon);

        //Test akses private - AKAN ERROR jika uncomment
        //person.nama = "Andi";         //ERROR - private
        //person.umur = 30;             //ERROR - private
        //person.methodPribadi();       //ERROR - private

        //Mengakses data private melalui public method
        Person.tampilkanInfo();

        //Mengakses private melalui public method
        Person.panggilMetodePribadi();

        System.out.println("\nDEMONTRASI ACCESS MODIFIER");
        System.out.println("public      : bisa diakses");
        System.out.println("Default     : bisa diakses(dalam package sama)");
        System.out.println("Protected   : bisa diakses(dalam package sama)");
        System.out.println("Private     : Tidak bisa diakses langsung");

    }
}

