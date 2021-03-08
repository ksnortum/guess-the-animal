package animals.view;

import animals.utils.PropertiesUtils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class TreeStatsPrinterView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void printTitle() {
        System.out.println(messagesBundle.getString("tree.stats.title"));
    }

    public void printRoot(String fact) {
        String format = messagesBundle.getString("tree.stats.root");
        String prompt = MessageFormat.format(format, fact);
        System.out.println(prompt);
    }

    public void printNodes(int numberOfNodes) {
        String format = messagesBundle.getString("tree.stats.nodes");
        String prompt = MessageFormat.format(format, numberOfNodes);
        System.out.println(prompt);
    }

    public void printAnimals(int numberOfAnimals) {
        String format = messagesBundle.getString("tree.stats.animals");
        String prompt = MessageFormat.format(format, numberOfAnimals);
        System.out.println(prompt);
    }

    public void printStatements(int numberOfStatements) {
        String format = messagesBundle.getString("tree.stats.statements");
        String prompt = MessageFormat.format(format, numberOfStatements);
        System.out.println(prompt);
    }

    public void printHeight(int height) {
        String format = messagesBundle.getString("tree.stats.height");
        String prompt = MessageFormat.format(format, height);
        System.out.println(prompt);
    }

    public void printMinimum(int minimumHeight) {
        String format = messagesBundle.getString("tree.stats.minimum");
        String prompt = MessageFormat.format(format, minimumHeight);
        System.out.println(prompt);
    }

    public void printAverage(double averageHeight) {
        String format = messagesBundle.getString("tree.stats.average");
        String prompt = MessageFormat.format(format, averageHeight);
        System.out.println(prompt);
    }
}
