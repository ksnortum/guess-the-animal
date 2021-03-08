package animals.view;

import animals.utils.PropertiesUtils;

import java.util.List;
import java.util.ResourceBundle;

public class AnimalPrinterView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void printAnimalsIKnow() {
        System.out.println(messagesBundle.getString("tree.list.animals"));
    }

    public void printAllAnimals(List<String> animals) {
        String format = messagesBundle.getString("tree.list.printf");
        animals.forEach(animal -> System.out.printf(format, animal));
    }
}
