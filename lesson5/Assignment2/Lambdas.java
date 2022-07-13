package lesson5.Assignment2;

import java.util.Scanner;
import java.util.function.Function;

public class Lambdas {
    public static Function<Integer, Boolean> isOdd() {
        return (i) -> (i % 2) != 0;
    }

    public static Function<Integer, Boolean> isPrime() {
        return (i) -> {
            if (i <= 1) return false;
            if (i <= 3) return true;
            if (i % 2 == 0 || i % 3 == 0) return false;

            for (int j = 5; j * j <= i; j += 6)
                if (i % j == 0 || i % (j + 2) == 0)
                    return false;

            return true;
        };
    }

    public static Function<Integer, Boolean> isPalindrome() {
        return (i) -> {
            int num = i;
            int rev = 0;

            do {
                rev = (rev * 10) + (num % 10);
                num /= 10;
            } while (num != 0);

            return i == rev;
        };
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int i = 0; i < tests; ++i) {
            int operation = scanner.nextInt();
            int number = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println(isOdd().apply(number) ? "ODD" : "EVEN");
                    break;
                case 2:
                    System.out.println(isPrime().apply(number) ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    System.out.println(isPalindrome().apply(number) ? "PALINDROME" : "NOT PALINDROME");
                    break;
                default:
                    System.out.println("INVALID OPERATION");
                    break;
            }
        }
    }
}
