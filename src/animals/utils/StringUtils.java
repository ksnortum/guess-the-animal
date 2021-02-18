package animals.utils;

import java.util.Locale;

public class StringUtils {
    public static String properCase(String in) {
        if (in == null || in.isBlank()) {
            return in;
        }

        in = in.strip().toLowerCase(Locale.ROOT);
        String firstLetter = in.substring(0, 1);
        String rest = in.substring(1);

        return firstLetter.toUpperCase(Locale.ROOT) + rest;
    }
}
