package animals.model;

import java.util.Locale;

public enum Article {
    A("a"),
    AN("an"),
    NONE("");

    private final String word;

    Article(String word) {
        this.word = word;
    }

    public static Article parseArticle(String phrase) {
        if (phrase == null || phrase.isBlank()) {
            return Article.NONE;
        }

        String[] parts = phrase.strip().split("\\s+");
        String candidate = parts[0].strip().toLowerCase(Locale.ROOT);

        for (Article article : Article.values()) {
            if (candidate.equals(article.getWord())) {
                return article;
            }
        }

        // Couldn't find an article, so create one
        return candidate.matches("[aeiou].*") ? Article.AN : Article.A;
    }

    public static String stripArticle(String phrase) {
        phrase = phrase.strip().toLowerCase(Locale.ROOT);

        for (Article article : Article.values()) {
            if (phrase.startsWith(article.getWord() + " ")) {
                int index = phrase.indexOf(" ");
                phrase = phrase.substring(index + 1).strip();
                break;
            }
        }

        return phrase;
    }

    public String getWord() {
        return word;
    }
}
