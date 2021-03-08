package animals.view;

import animals.utils.PropertiesUtils;

import java.util.ResourceBundle;

public class FirstAnimalControllerView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void printWantToLearn() {
        System.out.println(messagesBundle.getString("animal.wantLearn"));
    }

    public String getAskFavorite() {
        return messagesBundle.getString("animal.askFavorite");
    }
}
