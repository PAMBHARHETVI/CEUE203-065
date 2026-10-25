import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;
import java.util.*;

public class FolderReport {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");

        try (PrintWriter writer = new PrintWriter("folder-report.txt")) {
            writer.println("FOLDER TREE REPORT");
            writer.println("------------------");

            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(
                        Path file, BasicFileAttributes attrs) throws IOException {

                    writer.println("Name: " + file.getFileName());
                    writer.println("Size: " + attrs.size() + " bytes");
                    writer.println("Modified: " + attrs.lastModifiedTime());
                    writer.println("------------------");

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(
                        Path file, IOException exc) {
                    writer.println("Cannot access: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
        }

        System.out.println("Report saved to folder-report.txt");
    }
}