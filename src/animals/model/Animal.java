package animals.model;

public class Animal {
    private final String name;
    private final Article article;

    public Animal() {
        this("", Article.NONE);
    }

    public Animal(String name, Article article) {
        this.name = name;
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public Article getArticle() {
        return article;
    }

    public String getPhrase() {
        return String.format("%s %s", article.getWord(), name);
    }
}
