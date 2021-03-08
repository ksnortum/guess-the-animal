package animals.utils;

public class FileUtils {
    public static String getFileName(String fileType) {
        String languageType = System.getProperty("user.language", "en");
        languageType = "en".equals(languageType) ? "" : "_" + languageType ;
        return String.format("animals%s.%s", languageType, fileType);
    }
}
