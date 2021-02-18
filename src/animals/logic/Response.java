package animals.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Response {
    private static final List<String> AFFIRMATIONS = Arrays.asList(
            "y", "yes", "yeah", "yep", "sure", "right", "affirmative",
            "correct", "indeed", "you bet", "exactly", "you said it"
    );

    private static final List<String> NEGATIONS = Arrays.asList(
            "n", "no", "no way", "nah", "nope", "negative",
            "i don't think so", "yeah no"
    );

    public static boolean isYes(String response) {
        final String phrase = prepPhrase(response);

        return AFFIRMATIONS.stream().anyMatch(affirmation -> affirmation.equals(phrase));
    }

    public static boolean isNo(String response) {
        final String phrase = prepPhrase(response);

        return NEGATIONS.stream().anyMatch(negation -> negation.equals(phrase));
    }

    private static String prepPhrase(String phrase) {
        phrase = phrase.strip().toLowerCase(Locale.ROOT);

        if (phrase.endsWith(".") || phrase.endsWith("!")) {
            phrase = phrase.substring(0, phrase.length() - 1);
        }

        return phrase;
    }
}
