package animals.logic;

import animals.model.YesNoTree;
import animals.utils.Inputer;
import animals.utils.LanguageRules;
import animals.view.AnimalDistinguisherView;

public class AnimalDistinguisher {
    private final AnimalDistinguisherView view = new AnimalDistinguisherView();

    public void distinguish(String firstAnimal, String secondAnimal, YesNoTree tree) {
        String fact = getFact(firstAnimal, secondAnimal);
        boolean isYes = Inputer.nextYesNo(view.getIsCorrect(secondAnimal));
        view.printLearned();
        view.printAnimalFact(firstAnimal, fact, !isYes);
        view.printAnimalFact(secondAnimal, fact, isYes);
        view.printDistinguishStatement();
        view.printQuestionFact(fact);
        tree.insert(fact, secondAnimal, isYes);
    }

    public String getFact(String firstAnimal, String secondAnimal) {
        boolean done = false;
        String fact = null;

        while (!done) {
            String factPhrase = Inputer.nextString(view.getSpecifyFactPrompt(firstAnimal, secondAnimal));

            if (LanguageRules.isStatementCorrect(factPhrase)) {
                fact = LanguageRules.prepareStatement(factPhrase);
                done = true;
            } else {
                view.printFactFormatError();
            }
        }

        return fact;
    }
}
