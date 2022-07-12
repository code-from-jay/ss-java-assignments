package lesson2.Assignment3;

public class Triangle implements Shape {
    public final double Base;
    public final double Height;

    public Triangle(double base, double height) {
        Base = base;
        Height = height;
    }

    @Override
    public double calculateArea() {
        return Base * Height / 2;
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();

        // TODO(Jordan): This could seriously use some improvement, but for now it's fine.
        builder.append("*\n");
        int middleRows = (int) (Height - 1);
        for (int i = 0; middleRows > 1 || i < Base - 2; ++i, --middleRows) {
            builder.append("*".repeat(i + 2)).append("\n");
        }
        builder.append("*".repeat((int) Base)).append("\n");

        System.out.println(builder);
    }
}
