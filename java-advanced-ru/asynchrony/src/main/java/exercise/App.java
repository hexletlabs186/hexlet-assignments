package exercise;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("file1.txt", "file2.txt", "dest.txt");
        System.out.println(result.get());
        // END
    }

    @SneakyThrows
    public static String readFile (String file) {
        return Files.readString(Paths.get(file));
    }

    @SneakyThrows
    public static void writeFile(String file, String s) {
        Files.writeString(Paths.get(file), s);
    }

    public static CompletableFuture<String> unionFiles(String file1, String file2, String fileOut) {

        CompletableFuture<String> futureFile1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Retrieving first file");
            return App.readFile(file1);
        });


        CompletableFuture<String> futureFile2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Retrieving second file");
            return App.readFile(file2);
        });

        // выполняется после завершения первых двух
        System.out.println("Calculate density");
        CompletableFuture<String> futureResult = futureFile1.thenCombine(futureFile2, (s1, s2) -> {
            String result = s1;
            if (s2 != null) result += s2;
            App.writeFile(fileOut, result);
            return result;
        });

        return futureResult;
    }
}

