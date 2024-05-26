package exercise;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static void main(String[] args) {

        int[] numbers = {10, -4, 67, 100, -100, 8};

        System.out.println(App.getMinMax(numbers)); // => {min=-100, max=100}
    }

    @SneakyThrows
    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> result = new HashMap<>();

        MaxThread t1 = new MaxThread(numbers);
        t1.start();

        MinThread t2 = new MinThread(numbers);
        t2.start();

        t1.join();
        t2.join();

        result.put("max", t1.getResult());
        result.put("min", t2.getResult());

        return result;
    }

    // END
}
