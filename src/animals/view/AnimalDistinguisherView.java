package animals.view;

import animals.utils.LanguageRules;
import animals.utils.PropertiesUtils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class AnimalDistinguisherView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public String getIsCorrect(String animal) {
        String message = messagesBundle.getString("game.isCorrect");

        return MessageFormat.format(message, animal);
    }

    public void printLearned() {
        System.out.println(messagesBundle.getString("game.learned"));
    }

    public void printAnimalFact(String animal, String fact, boolean isYes) {
        String preparedFact;

        if (isYes) {
            preparedFact = LanguageRules.prepareAnimalFact(fact);
        } else {
            preparedFact = LanguageRules.prepareAnimalFactNegative(fact);
        }

        System.out.printf(preparedFact, LanguageRules.prepareAnimalDefiniteArticle(animal));
    }

    public void printDistinguishStatement() {
        System.out.println(messagesBundle.getString("game.distinguish"));
    }

    public void printQuestionFact(String fact) {
        System.out.println(LanguageRules.prepareQuestionFact(fact));
    }

    public String getSpecifyFactPrompt(String firstAnimal, String secondAnimal) {
        String message = messagesBundle.getString("statement.prompt");
        return MessageFormat.format(message, firstAnimal, secondAnimal);
    }

    public void printFactFormatError() {
        System.out.println(messagesBundle.getString("statement.error"));
    }
}
