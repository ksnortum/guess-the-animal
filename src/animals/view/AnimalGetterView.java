package animals.view;

import animals.utils.PropertiesUtils;

import java.util.ResourceBundle;

public class AnimalGetterView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void printAnimalError() {
        System.out.println(messagesBundle.getString("animal.error"));
    }
}
