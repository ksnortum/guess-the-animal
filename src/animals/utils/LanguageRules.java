package animals.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LanguageRules {
    private static final ResourceBundle patternsBundle = PropertiesUtils.getPatternsBundle();

    public static boolean isYes(String response) {
        return isCorrect(response, "positiveAnswer");
    }

    public static boolean isNo(String response) {
        return isCorrect(response, "negativeAnswer");
    }

    public static boolean isAnimalCorrect(String candidate) {
        return isCorrect(candidate, "animal");
    }

    public static String prepareAnimal(String candidate) {
        return doPatternAndReplace(candidate, "animal");
    }

    public static boolean isStatementCorrect(String candidate) {
        return isCorrect(candidate, "statement");
    }

    public static String prepareStatement(String candidate) {
        return doPatternAndReplace(candidate, "statement");
    }

    public static String prepareNegativeStatement(String candidate) {
        return doPatternAndReplace(candidate, "negative");
    }

    public static String prepareQuestion(String candidate) {
        return doPatternAndReplace(candidate, "question");
    }

    public static String prepareGuessAnimal(String candidate) {
        return doPatternAndReplace(candidate, "guessAnimal");
    }

    public static String prepareAnimalDefiniteArticle(String candidate) {
        return doPatternAndReplace(candidate, "definite");
    }

    public static String prepareAnimalFact(String candidate) {
        return doPatternAndReplace(candidate, "animalFact");
    }

    public static String prepareAnimalFactNegative(String candidate) {
        return doPatternAndReplace(candidate, "animalFactNegative");
    }

    public static String prepareQuestionFact(String candidate) {
        return doPatternAndReplace(candidate, "question");
    }

    private static boolean isCorrect(String candidate, String base) {
        return candidate.matches(patternsBundle.getString(String.format("%s.isCorrect", base)));
    }

    private static String doPatternAndReplace(String candidate, String base) {
        List<PatternAndReplacement> patternList = getPatternsAndReplacements(base);

        for (PatternAndReplacement line : patternList) {
            if (candidate.matches(line.getPattern())) {
                return candidate.replaceFirst(line.getPattern(), line.getReplacement());
            }
        }

        return "";
    }

    private static List<PatternAndReplacement> getPatternsAndReplacements(String base) {
        List<PatternAndReplacement> list = new ArrayList<>();
        int count = Integer.parseInt(patternsBundle.getString(base + ".count"));

        for (int i = 1; i <= count; i++) {
            String pattern = patternsBundle.getString(String.format("%s.%d.pattern", base, i));
            String replacement = patternsBundle.getString(String.format("%s.%d.replace", base, i));
            list.add(new PatternAndReplacement(pattern, replacement));
        }

        return list;
    }

    private static class PatternAndReplacement {
        private final String pattern;
        private final String replacement;

        public PatternAndReplacement(String pattern, String replacement) {
            this.pattern = pattern;
            this.replacement = replacement;
        }

        public String getPattern() {
            return pattern;
        }

        public String getReplacement() {
            return replacement;
        }
    }
}
