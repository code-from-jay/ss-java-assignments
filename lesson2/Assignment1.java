package lesson2;

import java.util.Scanner;
import java.util.Vector;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a list of numbers you want to add together:");

        String line = scanner.nextLine();
        scanner = new Scanner(line);

        Vector<Integer> ints = new Vector<>();
        while (scanner.hasNextInt()) {
            ints.add(scanner.nextInt());
        }

        int sum = 0;
        for (int value : ints) {
            sum += value;
        }

        System.out.println("The sum of your numbers is " + sum);
    }
}
