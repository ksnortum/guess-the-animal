package animals.view;

import animals.utils.PropertiesUtils;

import java.util.ResourceBundle;

public class MainControllerView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void welcome() {
        System.out.println();
        System.out.println(messagesBundle.getString("welcome"));
    }
}
