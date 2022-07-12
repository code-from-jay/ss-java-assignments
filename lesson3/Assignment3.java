package lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String filePath;
        while (true) {
            System.out.print("Please enter path to file to check: ");
            filePath = scanner.nextLine();
            var path = Path.of(filePath);
            if (!Files.isRegularFile(path) || !Files.isWritable(path)) {
                System.out.println("Invalid path!");
            } else {
                break;
            }
        }

        System.out.print("Please enter the character to check for: ");
        char c = scanner.nextLine().charAt(0);
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); ++i) {
                    if (line.charAt(i) == c)
                        charCount++;
                }
            }

            System.out.println("The character '" + c + "' appears " + charCount + " times!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
