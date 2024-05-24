package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Тест");
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }

    public static List<String> buildApartmentsList(List<Home> apartments, int i) {

        if (i > apartments.size()) i = apartments.size();
        return
                apartments.stream()
                        .sorted((h1, h2) -> h1.compareTo(h2))
                        .map(Home::toString)
                        .toList()
                        .subList(0, i);

    }
}

// END
