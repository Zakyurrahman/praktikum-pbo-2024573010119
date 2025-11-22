package modul_8.praktikum1;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void displayInfo(){
        System.out.println("Shape Color: " + color);
        System.out.println("Filled: " + filled);
    }
}
