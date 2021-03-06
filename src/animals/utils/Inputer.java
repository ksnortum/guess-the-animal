package animals.utils;

import animals.model.ClarifyingPhrase;

import java.util.*;

public class Inputer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();
    private static final ResourceBundle messagesBundle = PropertiesUtils.getMessagesBundle();
    private static final List<String> clarifyingPhrase =
            Arrays.asList(messagesBundle.getString("ask.again").split("\f"));

    public static String nextString(String prompt, boolean useLineSeparator) {
        if (!prompt.isBlank()) {
            if (useLineSeparator) {
                prompt = String.format("%s%n", prompt);
            }

            System.out.print(prompt);
        }

        return SCANNER.nextLine();
    }

    public static String nextString(String prompt) {
        return nextString(prompt, true);
    }

    public static boolean nextYesNo(String prompt) {
        String response = nextString(prompt);

        while(!LanguageRules.isYes(response) && !LanguageRules.isNo(response)) {
            prompt = clarifyingPhrase.get(random.nextInt(clarifyingPhrase.size()));
            response = nextString(prompt);
        }

        return LanguageRules.isYes(response);
    }

    public static void pause(String prompt) {
        nextString(prompt);
    }

    public static int nextInt(String prompt) {
        if (!prompt.isBlank()) {
            System.out.print(prompt);
        }

        int response = SCANNER.nextInt();
        SCANNER.nextLine();

        return response;
    }
}
