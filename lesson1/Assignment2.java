package lesson1;

import java.util.Scanner;

public class Assignment2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int value = randomRange();
        int attempts = 0;
        boolean errored = false;
        while (attempts < 5) {
            if (attempts != 0 && !errored) {
                System.out.println("Incorrect, try again.");
            }

            if (errored) errored = false;

            int guess = prompt("Enter a number between 1 and 100");

            if (guess < 1 || guess > 100)
            {
                System.out.println("Invalid number, try again.");
                errored = true;
                continue;
            }

            if (value - 10 <= guess && guess <= value + 10) {
                System.out.println("Close enough! My number was " + value + "!");
                return;
            }

            attempts++;
        }

        System.out.println("Sorry, the answer was " + value + "!");
    }

    private static int randomRange() {
        return (int)((Math.random() * (100 - 1)) + 1);
    }

    private static int prompt(String message) {
        System.out.print(message + ": ");
        return scanner.nextInt();
    }
}
