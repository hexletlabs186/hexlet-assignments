package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void main(String[] args) {
        User user1 = new User (1, "Ivan", "Ivanov", 30);
        Path path1 = Paths.get("/tmp/file1.json");
        Car car1 = new Car(1, "audi", "q3", "black", user1);
        App.save(path1, car1); // Сохраняет представление объекта в файл

        Path path2 = Paths.get("/tmp/file2.json");
        Car car2 = App.extract(path2); // Возвращает инстанс класса Car
        car2.getModel(); // "passat"
    }

    @SneakyThrows
    public static void save(Path path1, Car car1) {
        Files.writeString(path1, car1.serialize());
    }

    @SneakyThrows
    public static Car extract(Path path) {
        String json = Files.readString(path);
        return Car.unserialize(json);
    }
}

// END
