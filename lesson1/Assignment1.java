package lesson1;

public class Assignment1 {
    public static void main(String[] args) {
        // 1)
        System.out.println("1)");
        for (int i = 1; i <= 4; ++i) {
            System.out.println(repeat('*', i));
        }
        System.out.println(repeat('.', 9));

        // 2)
        System.out.println("2)");
        System.out.println(repeat('.', 10));
        for (int i = 3; i >= 0; --i) {
            System.out.println(repeat('*', i + 1));
        }

        // 3)
        System.out.println("3)");
        for (int i = 1; i <= 7; i += 2) {
            System.out.println(repeat(' ', 5 - (i / 2)) + repeat('*', i));
        }
        System.out.println(repeat('.', 11));

        // 4)
        System.out.println("4)");
        System.out.println(repeat('.', 11));
        for (int i = 7; i > 0; i -= 2) {
            System.out.println(repeat(' ', 5 - (i / 2)) + repeat('*', i));
        }
    }

    private static String repeat(char ch, int n) {
        return String.valueOf(ch).repeat(n);
    }
}
