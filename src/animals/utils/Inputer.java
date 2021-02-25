package animals.utils;

import animals.logic.Response;
import animals.model.ClarifyingPhrase;

import java.util.Scanner;

public class Inputer {
    private static final Scanner SCANNER = new Scanner(System.in);

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

        while(!Response.isYes(response) && !Response.isNo(response)) {
            prompt = ClarifyingPhrase.nextPhrase(); // = "yes or no";
            response = nextString(prompt);
        }

        return Response.isYes(response);
    }

    public static void pause(String prompt) {
        nextString(prompt);
    }
}
