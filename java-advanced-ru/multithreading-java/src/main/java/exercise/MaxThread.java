package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;

    private Integer result;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
       // super.run();
        System.out.println("MaxThread started");
        result = Arrays.stream(numbers).max().orElseGet(null);
        // как вернуть значение из треда? установить какую-то статик перменную в резу
        System.out.println("MaxThread finished");
    }

    public Integer getResult() {
        return result;
    }
}

// END
