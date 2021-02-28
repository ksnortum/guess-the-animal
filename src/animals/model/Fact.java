package animals.model;

import animals.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fact {
    private String factText;
    private Verb verb;

    public Fact() {
        this(null, "");
    }

    public Fact(String factText, String verbCandidate) {
        this.factText = Objects.requireNonNullElse(factText, "");
        this.verb = Verb.parseVerb(verbCandidate);
    }

    public String getFactText() {
        return factText;
    }

    public void setFactText(String factText) {
        this.factText = factText;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    @JsonIgnore
    public String getQuestion() {
        return String.format("%s %s?", StringUtils.properCase(verb.getQuestionForm()), factText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;

        return factText.equals(fact.factText) && verb == fact.verb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(factText, verb);
    }

    @Override
    public String toString() {
        return String.format("Fact{text=%s, verb=%s}", factText, verb);
    }
}
