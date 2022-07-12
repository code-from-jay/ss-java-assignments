package lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Assignment1 {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Please pass in the directory to list!");
            return;
        }

        String dir = args[0];
        Path dirPath = Path.of(dir);
        if (!Files.isDirectory(dirPath)) {
            System.err.println("Path '" + dir + "' is not a valid directory!");
            return;
        }

        System.out.println("Recursively listing all files and directories under '" + dir + "'...");
        Files.walk(dirPath)
                .forEach((file) -> {
                    if (Files.isDirectory(file)) System.out.print("[DIR ]: ");
                    else System.out.print("[FILE]: ");

                    System.out.println(file);
                });
    }
}
