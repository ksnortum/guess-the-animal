package animals.view;

import animals.utils.LanguageRules;
import animals.utils.PropertiesUtils;

import java.util.ResourceBundle;

public class KnowledgeTreePrinterView {
    private static final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();
    public static final String BAR = messagesBundle.getString("tree.print.vertical");
    public static final String BRANCH = messagesBundle.getString("tree.print.branch");
    public static final String CORNER = messagesBundle.getString("tree.print.corner");

    public void printAnimal(String printString, String animal) {
        System.out.printf("%s%s%n", printString, animal);
    }

    public void printQuestion(String printString, String fact) {
        String question = LanguageRules.prepareQuestion(fact);
        System.out.printf("%s%s%n", printString, question);
    }
}
