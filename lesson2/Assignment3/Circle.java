package lesson2.Assignment3;

import java.util.Vector;

public class Circle implements Shape {
    public final int Diameter;

    public Circle(int diameter) {
        Diameter = diameter;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(Diameter / 2., 2);
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();

        double offset_radius = (Diameter / 2.) - 0.5;
        for (int j = 0; j < Diameter; ++j) {
            for (int k = 0; k < Diameter; ++k) {
                double x = j - offset_radius;
                double y = k - offset_radius;
                if (x * x + y * y <= offset_radius * offset_radius + 1) {
                    builder.append("*  ");
                } else {
                    builder.append("   ");
                }
            }
            builder.append('\n');
        }

        System.out.println(builder);
    }
}
