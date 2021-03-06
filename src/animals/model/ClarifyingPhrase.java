package animals.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// TODO can be removed
public class ClarifyingPhrase {
    private static final Random RANDOM = new Random();

    private static final List<String> phrases = Arrays.asList(
            "I'm not sure I caught you: was it yes or no?",
            "Funny, I still don't understand, is it yes or no?",
            "Oh, it's too complicated for me: just tell me yes or no.",
            "Could you please simply say yes or no?",
            "Oh, no, don't try to confuse me: say yes or no."
    );

    public static String nextPhrase() {
        return phrases.get(RANDOM.nextInt(phrases.size()));
    }
}
