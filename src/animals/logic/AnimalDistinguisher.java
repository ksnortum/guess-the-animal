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
        Verb verb = fact.getVerb();
        String factText = fact.getFactText();
        System.out.println("I learned the following facts about animals:");
        System.out.printf(" - The %s %s %s.%n",
                firstAnimal.getName(),
                isYes ? verb.getNegativeForm() : verb.getPositiveForm(),
                factText);
        System.out.printf(" - The %s %s %s.%n",
                secondAnimal.getName(),
                isYes ? verb.getPositiveForm() : verb.getNegativeForm(),
                factText);
        System.out.println("I can distinguish these animals by asking the question:");
        System.out.println(fact.getQuestion());
        tree.insert(fact, secondAnimal, isYes);
    }

    public Fact getFact(Animal firstAnimal, Animal secondAnimal) {
        boolean done = false;
        Fact fact = null;

        while (!done) {
            System.out.printf("Specify a fact that distinguishes %s from %s.%n",
                    firstAnimal, secondAnimal);
            System.out.println("The sentence should satisfy one of the following templates:");
            System.out.println("- It can ...");
            System.out.println("- It has ...");
            System.out.println("- It is a/an ...");
            String factPhrase = Inputer.nextString("");
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
