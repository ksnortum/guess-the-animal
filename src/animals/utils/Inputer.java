package animals.utils;

import java.util.Scanner;

public class Inputer {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nextString(String prompt) {
        System.out.print(prompt);

        return SCANNER.nextLine();
    }
}
