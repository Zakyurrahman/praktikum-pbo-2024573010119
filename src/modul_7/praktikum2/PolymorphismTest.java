package modul_7.praktikum2;

public class PolymorphismTest {
    public static void main(String[] args){
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("Merah", 5.0);
        shapes[1] = new Rectangle("Biru", 4.8, 6.0);
        shapes[2] = new Triangle("Hijau", 3.0, 4.0);

        System.out.println("--- POLIMORFISME RUNTIME ---");
        for (Shape shape : shapes) {
            shape.draw();
            shape.calculateArea();
            shape.displayInfo();
            System.out.println();
        }

        System.out.println("--- INDIVIDUAL OBJECTS ---");
        Shape shape1 = new Circle("kuning", 7.0);
        Shape shape2 = new Rectangle("ungu", 5.0, 8.0);

        shape1.draw();
        shape2.draw();

        System.out.println("\n--- TYPE CHECKING ---");
        for (Shape shape : shapes){
            if (shape instanceof Circle){
                Circle circle = (Circle) shape;
                System.out.println("ini adalah Circle dengan radius: " + circle.calculateArea());
            } else if (shape instanceof  Rectangle) {
                Rectangle rectangel = (Rectangle) shape;
                System.out.println("Ini adalah Rectangle dengan luas: " + rectangel.calculateArea());
            } else if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                System.out.println("ini adalah Triangle dengan luas: " + triangle.calculateArea());
            }
        }
    }
}
