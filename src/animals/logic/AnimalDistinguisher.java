package animals.logic;

import animals.model.Animal;
import animals.model.Fact;
import animals.model.Verb;
import animals.model.YesNoTree;
import animals.utils.Inputer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalDistinguisher {
    // TODO get list of verbs from Verb?
    private static final String FACT_PHRASE_REGEX = "^It (?<verb>can|has|is) (?<fact>[^.!?]+)[.!?]*$";
    private static final Pattern FACT_PHRASE_PATTERN = Pattern.compile(FACT_PHRASE_REGEX, Pattern.CASE_INSENSITIVE);

    public void distinguish(Animal firstAnimal, Animal secondAnimal, YesNoTree tree) {
        Fact fact = getFact(firstAnimal, secondAnimal);
        boolean isYes = Inputer.nextYesNo(String.format("Is the statement correct for %s? ", secondAnimal));
        System.out.println("Wonderful! I've learned so much about animals!");
        tree.insert(fact, secondAnimal, isYes);
    }

    public Fact getFact(Animal firstAnimal, Animal secondAnimal) {
        boolean done = false;
        Fact fact = null;

        while (!done) {
            System.out.printf("Specify a fact that distinguishes %s from %s.%n",
                    firstAnimal, secondAnimal);
            String factPhrase = Inputer.nextString(
                    "The sentence should be of the format: 'It can/has/is ...'.");
            Matcher matcher = FACT_PHRASE_PATTERN.matcher(factPhrase);

            if (matcher.matches()) {
                fact = new Fact(matcher.group("fact"), matcher.group("verb"));
                done = true;
            } else {
                System.out.println("The examples of a statement:");
                System.out.println(" - It can fly");
                System.out.println(" - It has horn");
                System.out.println(" - It is a mammal");
            }
        }

        return fact;
    }
}
