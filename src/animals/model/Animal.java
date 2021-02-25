package animals.model;

import java.util.Objects;

public class Animal {
    private final String name;
    private final Article article;

    public Animal() {
        this("", Article.NONE);
    }

    public Animal(String name, Article article) {
        this.name = Objects.requireNonNullElse(name, "");
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public Article getArticle() {
        return article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;

        return name.equals(animal.name) && article == animal.article;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, article);
    }

    @Override
    public String toString() {
        return String.format("%s %s", article.getWord(), name);
    }
}
