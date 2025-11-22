package modul_6.praktikum2;

public class Car extends Vehicle{
   private int numberOfDoors;

   public Car(String brand, int speed, int numberOfDoors){
       super(brand, speed);
       this.numberOfDoors = numberOfDoors;
   }
   @Override
    public void start(){
       super.start();
       System.out.println("Car engine is running smoothly");
   }
   @Override
    public  void displayInfo(){
       super.displayInfo();
       System.out.println("Number of doors: " + numberOfDoors);
   }

   public void honk(){
       System.out.println("Beep beep!");
   }
}
