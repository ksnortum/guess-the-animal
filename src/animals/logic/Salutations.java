package animals.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Salutations {
    private final Random random = new Random();

    private final List<String> goodbyes = Arrays.asList(
            "So long!", "Farewell!", "Auf Wiedersehen!", "Goodbye!",
            "See you later!", "I'm outta here!", "Catch you on the flip side!",
            "Happy trails!", "Buh bye!", "Peace out!", "Have a nice day!",
            "See you soon!", "Bye!"
    );

    public void goodbye() {
        System.out.println(goodbyes.get(random.nextInt(goodbyes.size())));
    }
}
