package modul_6.praktikum1;

public class InheritenceTest  {
    public static void main(String[] args){
        Student student = new Student("Alice", 20, "2024573010111");

        student.displayInfo();
        student.study();
        student.greet();

        Person person = new Student("Bob", 22, "2024573010119");
        person.greet();
    }
}
