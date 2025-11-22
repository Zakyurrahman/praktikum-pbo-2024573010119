# LAPORAN PRAKTIKUM 6: INHERITENCE

---

***Nama: Muhammad Zakyurrahman***

***NIM: 2024573010119***

***Kelas: TI 2A***

---

## 1. Abstrak
   Inheritance atau pewarisan merupakan salah satu pilar utama dalam Pemrograman Berorientasi Objek
   (PBO) yang memungkinkan sebuah kelas untuk mewarisi atribut dan metode dari kelas lain. Melalui konsep ini,
   pengembang dapat membangun struktur program yang lebih efisien, terorganisasi, dan mudah dikembangkan tanpa perlu
   menulis ulang kode yang sama.
   Praktikum ini bertujuan untuk memahami bagaimana mekanisme inheritance diterapkan dalam bahasa pemrograman Java,
   terutama dalam konteks hubungan antara superclass dan subclass. Dalam penerapannya, konsep ini
   membantu menciptakan reusability (penggunaan ulang kode) dan polymorphism, di mana subclass dapat
   memodifikasi atau memperluas perilaku superclass sesuai kebutuhan.
   Melalui praktikum ini, mahasiswa diharapkan mampu menjelaskan bagaimana pewarisan digunakan untuk
   membentuk hierarki kelas, menerapkan method overriding, dan memahami bagaimana pemanggilan konstruktor superclass
   dilakukan. Hasil dari praktikum menunjukkan bahwa penggunaan inheritance dapat menyederhanakan desain sistem, mengurangi
   duplikasi kode, serta memperkuat konsep modularitas dalam pengembangan perangkat lunak berbasis objek.

## 2. Praktikum
   ### Dasar Teori
   Inheritance (Pewarisan) adalah salah satu prinsip fundamental dalam Object-Oriented Programming (OOP)
   yang memungkinkan sebuah class (subclass/child class) mewarisi sifat dan perilaku dari class lain (superclass/parent class). 
   Dengan inheritance, kita dapat menghindari duplikasi kode dan meningkatkan reusability.
   
***Tujuan Inheritance***
   - Code Reusability - Menggunakan kembali kode yang sudah ada tanpa menulis ulang.
   - Method Overriding - Memungkinkan subclass mengimplementasikan ulang method dari parent class.
   - Polymorphism - Memungkinkan objek subclass diperlakukan sebagai objek superclass.
   - Extensibility - Memperluas fungsionalitas class yang sudah ada.
   - Hierarchical Classification - Membuat hubungan hierarki antar class.
![img.png](img.png)

***Cara Implementasi***
1. Gunakan kata kunci extends untuk mewarisi dari sebuah class.
2. Subclass dapat mengakses anggota (fields dan methods) yang bersifat protected dan public dari
   superclass.
3. Subclass dapat mengoverride method dari superclass.
4. Gunakan kata kunci super untuk mengakses anggota superclass.
---
   ***Jenis-jenis Inheritance:***
#### 1. Single Inheritance
Single inheritance terjadi ketika sebuah class turunan hanya mewarisi dari satu class induk. Ini adalah bentuk
pewarisan yang paling sederhana, di mana class turunan mendapatkan semua metode dan properti dari satu class induk
saja.
![img_1.png](img_1.png)

Contoh:
````
//Super class
class Vehicle {
Vehicle() {
System.out.println("This is a Vehicle");
}
}
// Subclass
class Car extends Vehicle {
Car() {
System.out.println("This Vehicle is Car");
}
}
public class Test {
public static void main(String[] args) {
// Creating object of subclass invokes base class constructor
Car obj = new Car();
}
}
````

#### 2. Multiple Inheritance
   Multiple inheritance memungkinkan sebuah class turunan untuk mewarisi dari lebih dari satu class induk.
   Artinya, class turunan dapat menggabungkan fungsionalitas dari beberapa class induk. Multiple inheritance lebih kompleks
   dan harus ditangani dengan hati-hati untuk menghindari masalah seperti diamond problem, di mana class turunan
   mewarisi dari dua class induk yang memiliki class dasar sama.
![img_2.png](img_2.png)
    Contoh:
````
interface LandVehicle {
default void landInfo() {
System.out.println("This is a LandVehicle");
}
}
interface WaterVehicle {
default void waterInfo() {
System.out.println("This is a WaterVehicle");
}
}
// Subclass implementing both interfaces
class AmphibiousVehicle implements LandVehicle, WaterVehicle {
AmphibiousVehicle() {
System.out.println("This is an AmphibiousVehicle");
}
}
public class Test {
public static void main(String[] args) {
AmphibiousVehicle obj = new AmphibiousVehicle();
obj.waterInfo();
obj.landInfo();
}
}
````

#### 3. Hierarchical Inheritance
   Hierarchical inheritance terjadi saat beberapa class turunan mewarisi dari satu class induk yang sama. Jenis ini
   sering digunakan untuk mengelompokkan fungsionalitas yang serupa ke dalam satu class induk, sementara
   memungkinkan variasi dalam class turunan.
   ![img_3.png](img_3.png)
Contoh:
````
class Vehicle {
Vehicle() {
System.out.println("This is a Vehicle");
}
}
class Car extends Vehicle {
Car() {
System.out.println("This Vehicle is Car");
}
}
class Bus extends Vehicle {
Bus() {
System.out.println("This Vehicle is Bus");
}
}
public class Test {
public static void main(String[] args) {
Car obj1 = new Car();
Bus obj2 = new Bus();
}
}
````

#### 4. Multilevel Inheritance
   Dalam multilevel inheritance, sebuah class turunan mewarisi dari class turunan lain, sementara class yang
   sendiri mewarisi dari class induk. Jenis ini menciptakan "rantai" pewarisan. Misalnya, class C mewarisi dari class B, dan
   class B mewarisi dari class A.
   ![img_4.png](img_4.png)
   
Contoh:
````
class Vehicle {
Vehicle() {
System.out.println("This is a Vehicle");
}
}
class FourWheeler extends Vehicle {
FourWheeler() {
System.out.println("4 Wheeler Vehicles");
}
}
class Car extends FourWheeler {
Car() {
System.out.println("This 4 Wheeler Vehicle is a Car");
}
}
public class Geeks {
public static void main(String[] args) {
Car obj = new Car(); // Triggers all constructors in order
}
}
````

#### 5. Hybrid Inheritance
   Hybrid inheritance adalah kombinasi dari dua atau lebih jenis inheritance yang sebelumnya sudah disebutkan
   di atas. Kondisi ini sering terjadi dalam sistem yang lebih kompleks, di mana berbagai bentuk inheritance dipakai
   bersama-sama untuk mencapai fleksibilitas dan efisiensi yang diinginkan.
   ![img_5.png](img_5.png)
---

### Praktikum 1 : Memahami Single Inheritence
***Tujuan***
Memahami konsep dan implementasi single inheritence
---

#### Langkah Praktikum 1 : Single Inheritence
1. Buat class baru `person`.
2. Ketik kode: 
````
package modul_6.praktikum_1;

public class Person {
protected String name;
protected int age;
Buat class Student sebagai subclass yang mewarisi Person:
Buat class InheritanceTest untuk testing:
public Person(String name, int age) {
this.name = name;
this.age = age;
}
public void displayInfo() {
System.out.println("Name: " + name);
System.out.println("Age: " + age);
}
public void greet() {
System.out.println("Hello, I am a person.");
}
}
````
- Buat class `Student` sebagai subclass yang mewarisi Person:
````
package modul_6.praktikum_1;
public class Student extends Person{
private String studentId;
public Student(String name, int age, String studentId) {
super(name, age); // Memanggil constructor superclass
this.studentId = studentId;
}
public void study(){
System.out.println(name + " is studying.");
}
@Override
public void greet() {
System.out.println("Hello, I am a student named." + name);
}
}
````

- Buat class `InheritanceTest` untuk testing:
````
package modul_6.praktikum_1;
public class InheritanceTest {
public static void main(String[] args) {
Student student = new Student("Alice", 20, "S12345");
// Memanggil method dari superclass
student.displayInfo();
// Memanggil method dari subclass
student.study();
// Memanggil overridden method
student.greet();
// Polymorphism: Student sebagai Person
Person person = new Student("Bob", 22, "S67890");
person.greet(); // Memanggil method yang di-override
}
}
````

- Jalankan programnya:

***Screenshot Hasil***
![img_6.png](img_6.png)

##### Pembahasan

Dari hasil eksekusi program, dapat disimpulkan bahwa:
1. ***Inheritance*** memungkinkan Student untuk mewarisi atribut dan method dari Person tanpa harus
   menulis ulang
   kode.
2. ***Keyword*** super digunakan untuk mengakses constructor atau method dari superclass.
3. ***Method overriding*** memungkinkan subclass untuk mengubah perilaku dari method superclass sesuai
   kebutuhan.
4. ***Polymorphism*** memungkinkan referensi bertipe superclass ( Person ) menunjuk ke objek subclass
   ( Student ), tetapi
   tetap menjalankan implementasi method milik subclass.
5. Struktur hierarki ini membantu program menjadi lebih modular, efisien, dan mudah dikembangkan.

--- 

### Praktikum 2: Method Overriding dan Kata Kunci super

#### Teori Dasar

Method overriding memungkinkan subclass memberikan implementasi spesifik untuk method yang sudah
didefinisikan di superclass. Kata kunci super digunakan untuk mengakses anggota superclass.

Aturan Method Overriding:
1. Method harus memiliki nama dan parameter yang sama
2. Return type harus sama atau subtype (covariant return type)
3. Access modifier tidak boleh lebih restriktif
4. Tidak bisa override method yang final atau static
  
Penggunaan super:
1. `super()` - Memanggil constructor superclass
2. `super.methodName()` - Memanggil method superclass
3. `super.variableName` - Mengakses variable superclass
   
#### Tujuan:
   Memahami cara melakukan method overriding dan penggunaan kata kunci super .
   
---

### Langkah Praktikum : Method Overriding dan Kata Kunci `super`
1. Buat class baru `vehicle`.
2. Ketik kode:
````
package modul_6.praktikum_2;

public class Vehicle {
protected String brand;
protected int speed;
public Vehicle(String brand, int speed) {
this.brand = brand;
this.speed = speed;
}
public void start() {
System.out.println("Vehicle is starting...");
}
public void displayInfo() {
System.out.println("Brand: " + brand);
System.out.println("Speed: " + speed + " km/h");
}
}
````

- Buat class `Car` sebagai subclass yang mewarisi `Vehicle` :
````
package modul_6.praktikum_2;

public class Car extends Vehicle {
private int numberOfDoors;
public Car(String brand, int speed, int numberOfDoors) {
super(brand, speed);
this.numberOfDoors = numberOfDoors;
}
@Override
public void start() {
super.start();
System.out.println("Car engine is running smoothly");
}
@Override
public void displayInfo() {
super.displayInfo();
System.out.println("Number of Doors: " + numberOfDoors);
}
public void honk() {
System.out.println("Beep beep!");
}
}
````

- Buat class `OverrideTest` untuk testing:
````  
package modul_6.praktikum_2;
  
  public class OverrideTest {
  public static void main(String[] args) {
  Car car = new Car("Toyota", 180, 4);
  // Memanggil overridden method
  car.start();
  car.displayInfo();
  car.honk();
  // Demonstrasi polymorphism
  Vehicle vehicle = new Car("Honda", 200, 2);
  vehicle.start(); // Memanggil method yang di-override
  vehicle.displayInfo(); // Memanggil method yang di-override
  }
  }
````

- Jalankan program
- Cara method overriding bekerja
- Penggunaan kata kunci super untuk mengakses superclass
- Konsep polymorphism dalam inheritance

![img_7.png](img_7.png)

#### Pembahasan
Dari hasil eksekusi, dapat diamati hal-hal berikut:

***1. Inheritance (Pewarisan):***
   
Kelas Car mewarisi semua atribut dan metode dari Vehicle , memungkinkan penggunaan kembali kode
   tanpa duplikasi.

***2. Method Overriding:***
   
Subclass ( Car ) mengubah perilaku start() dan displayInfo() dari superclass ( Vehicle ) untuk
   menambahkan detail yang lebih spesifik.
   Hal ini menunjukkan bahwa overriding memungkinkan subclass untuk memperluas atau menyesuaikan
   perilaku bawaan superclass.

***3. Pemanggilan super:***
   
Keyword super digunakan untuk memanggil versi metode dari superclass, memastikan bahwa perilaku dasar
tetap dijalankan sebelum ditambahkan perilaku baru.

***4. Polymorphism:***

   Dengan mendeklarasikan objek subclass ( Car ) menggunakan referensi superclass ( Vehicle ), program
   memperlihatkan bahwa
   Java akan memilih implementasi metode yang sesuai dengan objek aktual, bukan tipe referensinya.
   Ini membuktikan prinsip runtime polymorphism.

***5. Ekstensi Fungsionalitas:***

   Kelas Car tidak hanya mewarisi tetapi juga menambahkan fungsionalitas baru seperti honk() ,
   memperlihatkan
   fleksibilitas pewarisan dalam memperluas perilaku kelas dasar.
   
---

## Praktikum 3: Multilevel dan Hierarchical Inheritance
#### Tujuan:
Memahami konsep multilevel dan hierarchical inheritance.

---

### Langkah Praktikum : Multilevel dan Hierarchical Inheritance
1. Buat class baru `Animal`.
2. ketik kode:

````
package modul_6.praktikum3;

public class Animal {
    protected String name;

    public Animal(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println(name + "is eating.");
    }

    public void sleep() {
        System.out.println(name + "is sleeping.");
    }
}
````
- Buat class `Mammal` yang mewarisi Animal (multilevel inheritence):
````
package modul_6.praktikum3;

public class Mammal extends Animal{
    protected String furColor;

    public Mammal(String name, String furColor){
        super(name);
        this.furColor = furColor;
    }

    public void giveBirth(){
        System.out.println(name + "is giving birth to live young.");
    }
}
````
- Buat class `Dog` yang mewarisi `Mammal` (multilevel inheritence):
````
package modul_6.praktikum3;

public class Dog  extends Mammal{
    private String breed;

    public Dog(String name, String furColor, String breed){
        super(name, furColor);
        this.breed = breed;
    }

    public void bark(){
        System.out.println(name + "is barking: Woof woof!");
    }

    @Override
    public void eat(){
        System.out.println(name + "the do is eating dog food.");
    }
}
````
- Buat class `Cat` yang mewarisi `Mammal` (hierarchical inheritence):
````
package modul_6.praktikum3;

public class Cat extends Mammal{
    private boolean isIndoor;

    public Cat(String name, String furColor, boolean isIndoor){
        super(name, furColor);
        this.isIndoor = isIndoor;
    }

    public void meow(){
        System.out.println(name + "is meowing: Meow meow!");
    }

    @Override
    public void eat(){
        System.out.println(name + "the cat is eating cat food.");
    }
}
````
- Buat class `InheritenceTypeTest` untuk testing:
````
package modul_6.praktikum3;

public class InheritenceTypeTest {
    public static void main(String[] args){
        Dog dog = new Dog("Buddy", "Brown", "Golden");
        dog.eat();
        dog.sleep();
        dog.giveBirth();
        dog.bark();

        System.out.println();

        Cat cat = new Cat("Whiskers", "White", true);
        cat.eat();
        cat.sleep();
        cat.giveBirth();
        cat.meow();

        System.out.println();

        Animal[] animals = {new Dog("Max", "Black", "Labrador"),
        new Cat("Luna", "Gray", false)};

        for (Animal animal : animals){
            animal.eat();
        }
    }
}
````
- Jalankan program
- Cara multilevel inheritance membentuk rantai pewarisan.
- Cara hierarchical inheritance memungkinkan multiple class mewarisi dari satu superclass.
- Polymorphism bekerja dengan inheritance hierarchy.

***Screenshot Hasil***
![img_8.png](img_8.png)

#### Pembahasan

Dari hasil program dapat disimpulkan beberapa poin penting:

1. ***Multilevel Inheritance*** membentuk rantai pewarisan di mana subclass dapat mewarisi semua atribut
   dan metode dari seluruh rantai kelas di atasnya.
   Contoh: Dog mewarisi dari Mammal , dan Mammal mewarisi dari Animal .

2. ***Hierarchical Inheritance*** memungkinkan beberapa kelas berbeda mewarisi dari satu superclass yang sama.
   Contohnya, Dog dan Cat sama-sama turunan dari Mammal .

3. ***Method Overriding*** memungkinkan setiap subclass mengubah perilaku metode yang diwarisi dari
superclass agar lebih sesuai dengan karakteristik masing-masing.

4. ***Polymorphism*** membuat program menjadi fleksibel, karena tipe referensi dapat berupa superclass
   ( Animal ), tetapi perilaku yang dijalankan sesuai dengan tipe objek sebenarnya di memori.

5. Penggunaan ***protected*** memastikan atribut seperti name tetap aman tetapi masih dapat digunakan
   oleh subclass tanpa perlu getter/setter.

---

## Praktikum 4: Sistem Manajemen Perpustakaan Sederhana
#### Tujuan:

Menerapkan konsep inheritance dalam project real-world sederhana untuk mengelola sistem perpustakaan.

#### Deskripsi Project:

Kita akan membuat sistem manajemen perpustakaan sederhana yang memiliki berbagai jenis item (buku,
majalah, DVD) dengan karakteristik yang berbeda namun memiliki beberapa kesamaan.

---

### Langkah Praktikum : Sistem Manajemen Perpustakaan Sederhana
1. Buat class baru `LibraryItem` .
2. Ketik kode:
````
package modul_6.praktikum_4;
public abstract class LibraryItem {
protected String itemId;
protected String title;
protected int year;
protected boolean isAvailable;
public LibraryItem(String itemId, String title, int year) {
this.itemId = itemId;
this.title = title;
this.year = year;
this.isAvailable = true;
}
// Getter Methods
public String getItemId() { return itemId; }
public String getTitle() { return title; }
public int getYear() { return year; }
public boolean isAvailable() { return isAvailable; }
// Setter methods
public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
// Abstract method yg harus diimplementasikan subclass
public abstract void displayInfo();
// Concrete method yg bisa digunakan semua subclass
public void borrowItem() {
if (isAvailable) {
isAvailable = false;
System.out.println(title + " berhasil dipinjam");
} else {
System.out.println(title + " sedang tidak tersedia");
}
}
public void returnItem() {
isAvailable = true;
System.out.println(title + " berhasil dikembalikan");
}
}
````
- Buat class `Book` yang mewarisi `LibraryItem` :
````
package modul_6.praktikum_4;
public class Book extends LibraryItem {
private String author;
private String isbn;
private int numberOfPages;
public Book(String itemId, String title, int year, String author, String isbn, int
numberOfPages) {
super(itemId, title, year);
this.author = author;
this.isbn = isbn;
this.numberOfPages = numberOfPages;
}
@Override
public void displayInfo() {
System.out.println("BUKU");
System.out.println("__________________________");
System.out.println("ID: " + itemId);
System.out.println("judul: " + title);
System.out.println("Penulis: " + author);
System.out.println("Tahun: " + year);
System.out.println("ISBN: " + isbn);
System.out.println("Jumlah Halaman: " + numberOfPages);
System.out.println("Status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
System.out.println("__________________________");
}
// Method khusus Book
public void readSample() {
System.out.println("Membaca sample dari buku: " + title);
}
}
````
- Buat class `Magazine` yang mewarisi `LibraryItem` :
````
package modul_6.praktikum_4;
public class Magazine extends LibraryItem {
private String publisher;
private int issueNumber;
private String category;
public Magazine(String itemId, String title, int year, String publisher, int
issueNumber, String category) {
super(itemId, title, year);
this.publisher = publisher;
this.issueNumber = issueNumber;
this.category = category;
}
@Override
public void displayInfo() {
System.out.println("--------MAJALAH--------");
System.out.println("ID: " + itemId);
System.out.println("Judul: " + title);
System.out.println("Penerbit: " + publisher);
System.out.println("Tahun: " + year);
System.out.println("Edisi: " + issueNumber);
System.out.println("Kategori: " + category);
System.out.println("Status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
System.out.println("-----------------------");
}
// Method khusus Magazine
public void browseArticles() {
System.out.println("Menelusuri artikel dalam majalah: " + title);
}
}
````
- Buat class `DVD` yang mewarisi `LibraryItem` :
````
package modul_6.praktikum_4;
public class DVD extends LibraryItem {
private String director;
private int duration;
private String genre;
public DVD(String itemId, String title, int year, String director, int duration, String
genre) {
super(itemId, title, year);
this.director = director;
this.duration = duration;
this.genre = genre;
}
@Override
public void displayInfo() {
System.out.println("-----DVD-----");
System.out.println("ID: " + itemId);
System.out.println("Judul: " + title);
System.out.println("Sutradara: " + director);
System.out.println("Tahun: " + year);
System.out.println("Durasi: " + duration + "menit");
System.out.println("Genre: " + genre);
System.out.println("Status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
System.out.println("-------------------------");
}
// Method khusus DVD
public void playTrailer() {
System.out.println("Memutar trailer DVD: " + title);
}
}
````
- Buat class `LibraryManagementSystem` sebagai main class:
````
package modul_6.praktikum_4;
import java.util.ArrayList;
import java.util.Scanner;
public class LibraryManagementSystem {
private static ArrayList<LibraryItem> libraryItems = new ArrayList<>();
private static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
initializeSampleData();
while (true) {
displayMenu();
int choice = scanner.nextInt();
scanner.nextLine(); // coonsume newline
switch (choice) {
case 1:
displayAllItems();
break;
case 2:
borrowItem();
break;
case 3:
returnItem();
break;
case 4:
addNewItem();
break;
case 5:
searchItem();
break;
case 6:
System.out.println("Terimas kasih telah menggunakan sistem
perpustakaan!");
return;
default:
System.out.println("Pilihan tidak valid!");
}
}
}
private static void displayMenu() {
System.out.println("\n--- SISTEMA MANAGEMENT PERPUSTAKAAN ---");
System.out.println("1. Tampilkan Semua Item");
System.out.println("2. Pinjam Item");
System.out.println("3. Kembalikan Item");
System.out.println("4. Tambah Item Baru");
System.out.println("5. Cari Item");
System.out.println("6. Keluar");
System.out.println("Pilih Menu: ");
}
private static void initializeSampleData() {
// Tambahkan sample data
libraryItems.add(new Book("B001", "Pemrograman Java", 2023, "Budi Santoso", "978-
1234567890", 350));
libraryItems.add(new Book("B002", "Struktur Data", 2022, "Sari Dewi", "978-
0987654321", 280));
libraryItems.add(new Magazine("M001", "National Geographic", 2024, "NG Media", 245,
"Sains"));
libraryItems.add(new DVD("D001", "The Java Documentary", 2023, "John Programmer",
120, "Edukasi"));
}
private static void displayAllItems() {
System.out.println("\n--- DAFTAR SEMUA ITEM PERPUSTAKAAN ---");
for (LibraryItem item : libraryItems) {
item.displayInfo();
System.out.println();
}
}
private static void borrowItem() {
System.out.print("Masukkan ID Item yang ingin dipinjam: ");
String itemId = scanner.nextLine();
for (LibraryItem item : libraryItems) {
if (item.getItemId().equalsIgnoreCase(itemId)) {
item.borrowItem();
return;
}
}
System.out.println("Item dengan ID " + itemId + " tidak ditemukan!");
}
private static void returnItem() {
System.out.print("Masukkan ID Item yang ingin dikembalikan: ");
String itemId = scanner.nextLine();
for (LibraryItem item : libraryItems) {
if (item.getItemId().equalsIgnoreCase(itemId)) {
item.returnItem();
return;
}
}
System.out.println("Item dengan ID " + itemId + " tidak ditemukan!");
}
private static void addNewItem() {
System.out.println("\n--- TAMBAH ITEM BARU ---");
System.out.println("1. Buku");
System.out.println("2. Majalah");
System.out.println("3. DVD");
System.out.print("Pilih jenis item: ");
int type = scanner.nextInt();
scanner.nextLine();
System.out.print("ID Item: ");
String itemId = scanner.nextLine();
System.out.print("Judul: ");
String title = scanner.nextLine();
System.out.print("Tahun: ");
int year = scanner.nextInt();
scanner.nextLine();
switch (type) {
case 1:
System.out.print("Penulis: ");
String author = scanner.nextLine();
System.out.print("ISBN: ");
String isbn = scanner.nextLine();
System.out.print("Jumlah Halaman: ");
int pages = scanner.nextInt();
libraryItems.add(new Book(itemId, title, year, author, isbn, pages));
break;
case 2:
System.out.print("Penerbit: ");
String publisher = scanner.nextLine();
System.out.print("Edisi: ");
int issue = scanner.nextInt();
scanner.nextLine();
System.out.print("Kategori: ");
String category = scanner.nextLine();
libraryItems.add(new Magazine(itemId, title, year, publisher, issue,
category));
break;
case 3:
System.out.print("Sutradara: ");
String director = scanner.nextLine();
System.out.print("Durasi (menit): ");
int duration = scanner.nextInt();
scanner.nextLine();
System.out.print("Genre: ");
String genre = scanner.nextLine();
libraryItems.add(new DVD(itemId, title, year, director, duration, genre));
break;
default:
System.out.println("Jenis item tidak valid!");
break;
}
System.out.println("Item berhasil ditambahkan!");
}
private static void searchItem() {
System.out.print("Masukkan kata kunci pencarian (judul/penulis): ");
String keyword = scanner.nextLine().toLowerCase();
System.out.println("\n---- HASIL PENCARIIAN ----");
boolean found = false;
for (LibraryItem item : libraryItems) {
if (item.getTitle().toLowerCase().contains(keyword)) {
item.displayInfo();
System.out.println();
found = true;
}
}
if (!found) {
System.out.println("Tidak ada item yang sesuai dengan pencarian.");
}
}
}
````
- Jalankan program dan uji semua fitur:
- Menampilkan semua item
- Meminjam dan mengembalikan item
- Menambah item baru
- Mencari item berdasarkan kata kunci

#### Screenshot Hasil
##### Menampilkan semua item
![img_9.png](img_9.png)
![img_10.png](img_10.png)
- Meminjam dan mengembalikan item
![img_11.png](img_11.png)
- Tambah item baru
![img_12.png](img_12.png)
- Cari item berdasarkan kata kunci
![img_13.png](img_13.png)
- Akhiri Program
![img_14.png](img_14.png)

#### Pembahasan

Program ini berhasil menerapkan prinsip-prinsip OOP secara lengkap:

***1. Pewarisan dan Hierarki Kelas:***
   Setiap subclass ( `Book` , `Magazine` , `DVD` ) mewarisi perilaku umum dari LibraryItem , tetapi juga memiliki perilaku
   khususnya masing-masing.

***2. Polymorphism yang Efektif:***
   Penggunaan `ArrayList<LibraryItem>` memungkinkan sistem menangani berbagai jenis objek secara
   dinamis tanpa harus mengetahui tipe pastinya.

***3. Abstraksi yang Tepat:***
   Kelas LibraryItem berfungsi sebagai blueprint bagi semua jenis item, memastikan setiap subclass memiliki struktur yang
   konsisten.
***4. Modularitas dan Skalabilitas:***
   Program mudah diperluas - misalnya, menambah jenis item baru (seperti EBook ) cukup dengan membuat
   subclass baru tanpa mengubah struktur utama sistem.

***5. Keterpaduan dengan Dunia Nyata:***
   Program ini mensimulasikan manajemen perpustakaan sederhana dengan konsep mirip sistem nyata:
   peminjaman, pengembalian, dan pencarian item.

---

## 3. Kesimpulan
   Dari rangkaian praktikum bertema Inheritance pada mata kuliah Pemrograman Berorientasi Objek (PBO), dapat
   disimpulkan bahwa konsep pewarisan merupakan fondasi penting dalam membangun sistem yang terstruktur, efisien, dan mudah
   dikembangkan. Melalui berbagai implementasi - mulai dari ***single inheritance***, ***multilevel inheritance***, **
   *hierarchical inheritance***, hingga penerapan ***abstract class*** - mahasiswa dapat memahami bagaimana
   hubungan antar kelas dibangun dan dimanfaatkan untuk menciptakan perilaku yang lebih kompleks tanpa harus menulis
   ulang kode yang sama. 
   
Konsep inheritance memungkinkan sebuah kelas (subclass) untuk mewarisi atribut dan method dari kelas
   lain (superclass), sehingga:
1. ***Meningkatkan reusability (penggunaan ulang kode)*** karena logika dasar dapat digunakan oleh
   banyak kelas turunan.
2. ***Mendukung modularitas dan keteraturan kode***, karena setiap kelas memiliki tanggung jawab yang
   jelas sesuai hierarkinya.
3. ***Memperkuat konsep polymorphism***, di mana satu referensi dapat merujuk ke banyak bentuk objek
   dan menjalankan perilaku berbeda tergantung jenis aktualnya.
4. ***Mendorong abstraksi***, dengan menggunakan abstract class sebagai cetak biru perilaku umum yang dapat
   diimplementasikan secara spesifik oleh subclass.
   
Dari serangkaian eksperimen (seperti Person-Student , Vehicle-Car , Animal-Mammal-Dog/Cat , hingga
`LibraryItem-Book/Magazine/DVD` ), terlihat bahwa:
   - ***Method overriding*** menjadi kunci utama untuk menyesuaikan perilaku subclass tanpa mengubah
   struktur superclass.
   - ***Super keyword*** digunakan untuk mengakses anggota superclass dalam pewarisan berantai.
   - ***Polymorphism*** dinamis menjadikan program lebih fleksibel dan mudah dikembangkan.
   

Secara keseluruhan, penerapan konsep inheritance tidak hanya memperkuat pemahaman mahasiswa
terhadap prinsip OOP, tetapi juga menunjukkan bagaimana teori pewarisan dapat diterapkan secara praktis dalam perancangan sistem
nyata seperti manajemen data, kendaraan, hewan, hingga perpustakaan digital.
Dengan demikian, konsep ini merupakan pondasi yang esensial untuk melangkah ke tingkat desain perangkat
lunak yang lebih kompleks dan efisien.

## 4. REFERENSI
- Oracle. Java SE Documentation. https://docs.oracle.com/javase
- Modul Praktikum PBO, Modul 2: Dasar Pemrograman Java
- Deitel, P. J., & Deitel, H. M. (2017). Java: How to Program (10th Edition). Pearson Education.
- Nugroho, Adi. (2010). Rekayasa Perangkat Lunak Berorientasi Objek dengan Metode UML dan Java. Andi Offset.
- Wahana Komputer. (2019). Pemrograman Java untuk Pemula. Elex Media Komputindo.
- Sutanta, Edhy. (2011). Basis Data dalam Tinjauan Konseptual. Andi Offset.
- Pressman, Roger S. (2010). Software Engineering: A Practitioner’s Approach (7th Edition). McGraw-Hill.