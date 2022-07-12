package lesson2.Assignment3;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(8, 5);
        double area = rectangle.calculateArea();
        System.out.println("The area of this rectangle is " + area);
        rectangle.display();

        Triangle triangle = new Triangle(5, 8);
        area = triangle.calculateArea();
        System.out.println("The area of this triangle is " + area);
        triangle.display();

        Circle circle = new Circle(8);
        area = circle.calculateArea();
        System.out.println("The area of this circle is " + area);
        circle.display();
    }
}
