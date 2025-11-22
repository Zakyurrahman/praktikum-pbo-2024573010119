package modul_8.praktikum2;

public interface Vehicle {
    int MAX_SPEED = 200;


    void start();
    void stop();
    void accelerate(double speed);
    void brake();


    default void honk() {
        System.out.println("Beep beep!");
    }


    static void displayMaxSpeed() {
        System.out.println("Maximum speed for all vehicles: " + MAX_SPEED + " km/h");
    }
}


