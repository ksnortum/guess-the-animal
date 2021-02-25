package animals.model;

import java.util.Locale;

public enum Verb {
    CAN("can", "can't", "can it"),
    HAS("has", "doesn't have", "does it have"),
    IS("is", "isn't", "is it"),
    NONE("", "", "");

    private final String positiveForm;
    private final String negativeForm;
    private final String questionForm;

    Verb(String positiveForm, String negativeForm, String questionForm) {
        this.positiveForm = positiveForm;
        this.negativeForm = negativeForm;
        this.questionForm = questionForm;
    }

    public static Verb parseVerb(String candidate) {
        if (candidate == null || candidate.isBlank()) {
            return Verb.NONE;
        }

        candidate = candidate.strip().toLowerCase(Locale.ROOT);

        for (Verb verb : Verb.values()) {
            if (candidate.equals(verb.getPositiveForm())) {
                return verb;
            }
        }

        return Verb.NONE;
    }

    public String getPositiveForm() {
        return positiveForm;
    }

    public String getNegativeForm() {
        return negativeForm;
    }

    public String getQuestionForm() {
        return questionForm;
    }
}
