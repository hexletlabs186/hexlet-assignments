package exercise;

// BEGIN
import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;

    private Integer result;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        // super.run();
        System.out.println("MinThread started");
        result = Arrays.stream(numbers).min().orElseGet(null);
        // как вернуть значение из треда? установить какую-то статик перменную в резу
        System.out.println("MinThread finished");
    }

    public Integer getResult() {
        return result;
    }
}

// END

// END
