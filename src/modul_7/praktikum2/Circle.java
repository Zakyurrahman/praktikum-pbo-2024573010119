package modul_7.praktikum2;

public class Circle extends Shape{
    private double radius;

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw(){
        System.out.println("Menggamber Lingkaran dengan warna:" + color + " dan radius :" + radius);
    }

    @Override
    public double calculateArea(){
        double area = Math.PI * radius * radius;
        System.out.println("Luas Lingkaran: " + area);
        return area;
    }

    @Override
    public void displayInfo(){
        System.out.println("Lingkaran - warna: " + color + ", radius: " + radius);
    }
}


