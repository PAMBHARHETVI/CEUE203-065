import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Files.write(Paths.get("log1.txt"), Arrays.asList(
            "INFO: Server started",
            "ERROR: File not found",
            "INFO: Request received"
        ));

        Files.write(Paths.get("log2.txt"), Arrays.asList(
            "WARNING: Low memory",
            "ERROR: Connection failed"
        ));

        String keyword = "ERROR";
        int totalLines = 0;
        int matchingLines = 0;

        String[] files = {"log1.txt", "log2.txt"};

        for (String file : files) {
            Path path = Paths.get(file);
            int fileLines = 0;

            for (String line : Files.readAllLines(path)) {
                totalLines++;
                fileLines++;

                if (line.contains(keyword)) {
                    matchingLines++;
                }
            }

            System.out.println("File: " + file);
            System.out.println("Size: " + Files.size(path) + " bytes");
            System.out.println("Lines: " + fileLines);
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": " + matchingLines);
    }
}