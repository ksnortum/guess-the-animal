package animals.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtils {
    private static final Locale locale = Locale.forLanguageTag(System.getProperty("user.language", "en"));

    public static ResourceBundle getMessagesBundle() {
        return ResourceBundle.getBundle("messages", locale);
    }

    public static ResourceBundle getPatternsBundle() {
        return ResourceBundle.getBundle("patterns", locale);
    }
}
