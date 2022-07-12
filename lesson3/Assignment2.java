package lesson3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String filePath;
        while (true) {
            System.out.print("Please enter path to file you want to append to: ");
            filePath = scanner.nextLine();
            var path = Path.of(filePath);
            if (!Files.isRegularFile(path) || !Files.isWritable(path)) {
                System.out.println("Invalid path!");
            } else {
                break;
            }
        }

        System.out.print("Please enter line you want to append: ");
        String line = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            System.out.println("Successfully appended line!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
