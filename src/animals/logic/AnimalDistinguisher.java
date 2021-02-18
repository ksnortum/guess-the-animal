package animals.logic;

import animals.model.Animal;
import animals.model.Fact;
import animals.model.Verb;
import animals.utils.Inputer;
import animals.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalDistinguisher {
    // TODO get list of verbs from Verb
    private static final String FACT_PHRASE_REGEX = "^It (?<verb>can|has|is) (?<fact>[^.!?]+)[.!?]*$";
    private static final Pattern FACT_PHRASE_PATTERN = Pattern.compile(FACT_PHRASE_REGEX, Pattern.CASE_INSENSITIVE);

    public void distinguish(Animal firstAnimal, Animal secondAnimal) {
        Fact fact = getFact(firstAnimal, secondAnimal);
        String yesOrNoText = Inputer.nextYesNo(String.format("Is it correct for %s? ",
                secondAnimal.getPhrase()));
        boolean isYes = Response.isYes(yesOrNoText);
        Verb verb = fact.getVerb();
        String factText = fact.getFact();
        System.out.println("I learned the following facts about animals:");
        System.out.printf(" - The %s %s %s.%n",
                firstAnimal.getName(),
                isYes ? verb.getNegative() : verb.getPositive(),
                factText);
        System.out.printf(" - The %s %s %s.%n",
                secondAnimal.getName(),
                isYes ? verb.getPositive() : verb.getNegative(),
                factText);
        System.out.println("I can distinguish these animals by asking the question:");
        System.out.printf(" - %s %s?%n",
                StringUtils.properCase(verb.getQuestion()),
                factText);
    }

    private Fact getFact(Animal firstAnimal, Animal secondAnimal) {
        boolean done = false;
        Fact fact = null;

        while (!done) {
            System.out.printf("Specify a fact that distinguishes %s from %s.%n",
                    firstAnimal.getPhrase(), secondAnimal.getPhrase());
            String factPhrase = Inputer.nextString(
                    "The sentence should be of the format: 'It can/has/is ...'.");
            Matcher matcher = FACT_PHRASE_PATTERN.matcher(factPhrase);

            if (matcher.matches()) {
                fact = new Fact(matcher.group("fact"), matcher.group("verb"));
                done = true;
            } else {
                // TODO print examples (do they need to be dynamic?)
                System.out.printf("The examples of a statement:%n" +
                        " - It can fly%n" +
                        " - It has horn%n" +
                        " - It is a mammal%n");
            }
        }

        return fact;
    }
}
