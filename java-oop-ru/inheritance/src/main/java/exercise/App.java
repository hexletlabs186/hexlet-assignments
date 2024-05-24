package exercise;


import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
    //    Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
    //    System.out.println(img.toString());
         // <img class="v-10" id="wop">


        Tag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );

        System.out.println(div.toString());

    }
}
