package lesson2.Assignment3;

public class Rectangle implements Shape {
    public final double Width;
    public final double Height;

    public Rectangle(double width, double height) {
        Width = width;
        Height = height;
    }

    @Override
    public double calculateArea() {
        return Width * Height;
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        for (int h = 0; h < Height; ++h) {
            builder.append("*".repeat((int)Width)).append("\n");
        }
        System.out.println(builder);
    }
}
