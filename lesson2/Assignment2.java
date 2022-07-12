package lesson2;

import java.util.Random;

public class Assignment2 {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        var values = new int[10][10];
        for (int j = 0; j < values.length; ++j) {
            for (int k = 0; k < values[j].length; ++k) {
                values[j][k] = rand.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        int posX = -1, posY = -1;

        for (int j = 0; j < values.length; ++j) {
            for (int k = 0; k < values[j].length; ++k) {
                if (values[j][k] > max) {
                    max = values[j][k];
                    posX = j;
                    posY = k;
                }
            }
        }

        System.out.printf("The max number in the array was %d which was located at (%d, %d)%n", max, posX, posY);
    }
}
