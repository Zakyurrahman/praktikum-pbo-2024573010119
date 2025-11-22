package modul_6.praktikum2;

public class OverrideTest {
    public static void main(String[] args){
        Car car = new Car("Toyota", 180, 4);

        car.start();
        car.displayInfo();
        car.honk();

        Vehicle vehicle = new Car("Honda", 200, 2);
        vehicle.start();
        vehicle.displayInfo();
    }
}
