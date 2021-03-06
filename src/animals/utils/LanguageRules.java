package animals.utils;

import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LanguageRules {
    private static final ResourceBundle patternsBundle = PropertiesUtils.getPatternsBundle();
    private static final Pattern positiveAnswer =
            Pattern.compile(patternsBundle.getString("positiveAnswer.isCorrect"), Pattern.CASE_INSENSITIVE);
    private static final Pattern negativeAnswer =
            Pattern.compile(patternsBundle.getString("negativeAnswer.isCorrect"), Pattern.CASE_INSENSITIVE);

    public static boolean isYes(String response) {
        return positiveAnswer.matcher(response).matches();
    }

    public static boolean isNo(String response) {
        return negativeAnswer.matcher(response).matches();
    }
}
