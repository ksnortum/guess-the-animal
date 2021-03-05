package animals.view;

import animals.utils.PropertiesUtils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MenuView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void printMenu() {
        System.out.println();
        System.out.println(messagesBundle.getString("menu.property.title"));
        System.out.println();
        System.out.printf("1. %s%n", messagesBundle.getString("menu.entry.play"));
        System.out.printf("2. %s%n", messagesBundle.getString("menu.entry.list"));
        System.out.printf("3. %s%n", messagesBundle.getString("menu.entry.search"));
        System.out.printf("4. %s%n", messagesBundle.getString("menu.entry.statistics"));
        System.out.printf("5. %s%n", messagesBundle.getString("menu.entry.print"));
        System.out.printf("0. %s%n", messagesBundle.getString("menu.property.exit"));
    }

    public void badOption() {
        String message = MessageFormat.format(messagesBundle.getString("menu.property.error"), 5);
        System.out.println(message);
    }
}
