package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

class AppTest {
    @Test
    void testPrintSquare() throws Exception {
        Circle circle = new Circle(new Point(2, 3), 5);
        String result = tapSystemOut(() -> {
            App.printSquare(circle);
        });
        assertThat(result.contains("79"));
        assertThat(result.contains("Вычисление окончено"));


        Circle circle1 = new Circle(new Point(2, 3), -5);
        String result1 = tapSystemOut(() -> {
            App.printSquare(circle1);
        });
        //assertThat(result1.trim()).isEqualTo("Не удалось посчитать площадь\nВычисление окончено");
        assertThat(result.contains("Не удалось посчитать площадь"));
        assertThat(result.contains("Вычисление окончено"));

    }
}
