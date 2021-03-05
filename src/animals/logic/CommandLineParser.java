package animals.logic;

import java.util.Locale;

public class CommandLineParser {
    public String parseFileType(String... args) {
        Locale locale = Locale.forLanguageTag(System.getProperty("user.language", "en"));
        Locale.setDefault(locale); // So toLower(Locale.ROOT) will work
        String fileType = "json";
        int paramIndex = 0;

        if (args.length % 2 != 0) {
            System.out.println("Bad number of parameters");

            return fileType;
        }

        while (paramIndex < args.length) {
            if ("-type".equals(args[paramIndex])) {
                fileType = args[++paramIndex].toLowerCase(Locale.ROOT);

                switch (fileType) {
                    case "json":
                    case "xml":
                    case "yaml":
                        break;
                    default:
                        System.out.println("Bad file type, defaulting to JSON");
                }
            } else {
                System.out.println("Bad command line parameter");
            }

            paramIndex++;
        }

        return fileType;
    }
}
