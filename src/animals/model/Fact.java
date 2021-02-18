package animals.model;

public class Fact {
    private final String fact;
    private final Verb verb;

    public Fact(String fact, String verbCandidate) {
        this.fact = fact;
        this.verb = Verb.parseVerb(verbCandidate);
    }

    public String getFact() {
        return fact;
    }

    public Verb getVerb() {
        return verb;
    }
}
