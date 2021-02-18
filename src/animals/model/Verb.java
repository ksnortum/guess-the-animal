package animals.model;

import java.util.Locale;

public enum Verb {
    CAN("can", "can't", "can it"),
    HAS("has", "doesn't have", "does it have"),
    IS("is", "isn't", "is it"),
    NONE("", "", "");

    private final String positive;
    private final String negative;
    private final String question;

    Verb(String positive, String negative, String question) {
        this.positive = positive;
        this.negative = negative;
        this.question = question;
    }

    public static Verb parseVerb(String candidate) {
        if (candidate == null || candidate.isBlank()) {
            return Verb.NONE;
        }

        candidate = candidate.strip().toLowerCase(Locale.ROOT);

        for (Verb verb : Verb.values()) {
            if (candidate.equals(verb.getPositive())) { // TODO or equals negative?
                return verb;
            }
        }

        return Verb.NONE;
    }

    public String getPositive() {
        return positive;
    }

    public String getNegative() {
        return negative;
    }

    public String getQuestion() {
        return question;
    }
}
