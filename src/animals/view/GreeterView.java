package animals.view;

import animals.utils.PropertiesUtils;

import java.util.ResourceBundle;

public class GreeterView {
    private final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();

    public void printMorningGreeting() {
        System.out.println(messagesBundle.getString("greeting.morning"));
    }

    public void printAfternoonGreeting() {
        System.out.println(messagesBundle.getString("greeting.afternoon"));
    }

    public void printEveningGreeting() {
        System.out.println(messagesBundle.getString("greeting.evening"));
    }

    public void printNightGreeting() {
        System.out.println(messagesBundle.getString("greeting.night"));
    }

    public void printEarlyGreeting() {
        System.out.println(messagesBundle.getString("greeting.early"));
    }
}
