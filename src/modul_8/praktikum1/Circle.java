package modul_8.praktikum1;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, boolean filled, double radius){
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void displayInfo(){
        System.out.println("CIRCLE");
        super.displayInfo();
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculatePerimeter());
        System.out.println("===============");
    }

    public double getDiameter(){
        return 2 * radius;
    }
}
