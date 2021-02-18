package animals.utils;

import animals.logic.Response;

import java.util.Scanner;

public class Inputer {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nextString(String prompt, boolean useLineSeparator) {
        if (useLineSeparator) {
            prompt = String.format("%s%n", prompt);
        }

        System.out.print(prompt);

        return SCANNER.nextLine();
    }

    public static String nextString(String prompt) {
        return nextString(prompt, true);
    }

    public static String nextYesNo(String prompt) {
        String response = nextString(prompt);

        while(!Response.isYes(response) && !Response.isNo(response)) {
            prompt = "yes or no";
            response = nextString(prompt);
        }

        return response;
    }
}
