package animals.view;

import animals.utils.LanguageRules;
import animals.utils.PropertiesUtils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class AnimalSearcherView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public String getEnterTheAnimal() {
        return messagesBundle.getString("animal.prompt");
    }

    public void printFactsAbout(String searchAnimal) {
        String message = messagesBundle.getString("tree.search.facts");
        String theAnimal = LanguageRules.prepareAnimalDefiniteArticle(searchAnimal);
        String prompt = MessageFormat.format(message, theAnimal);
        System.out.println(prompt);
    }

    public void printNoFactsAbout(String searchAnimal) {
        String message = messagesBundle.getString("tree.search.noFacts");
        String theAnimal = LanguageRules.prepareAnimalDefiniteArticle(searchAnimal);
        String prompt = MessageFormat.format(message, theAnimal);
        System.out.println(prompt);
    }

    public void printPositiveFact(String fact) {
        String format = messagesBundle.getString("tree.search.printf");
        System.out.printf(format, fact);
    }

    public void printNegativeFact(String fact) {
        String format = messagesBundle.getString("tree.search.printf");
        String negativeFact = LanguageRules.prepareNegativeStatement(fact);
        System.out.printf(format, negativeFact);
    }
}
