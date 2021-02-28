package animals.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Animal {
    private String name;
    private Article article;

    public Animal() {
        this("", Article.NONE);
    }

    public Animal(String name, Article article) {
        this.name = Objects.requireNonNullElse(name, "");
        this.article = Objects.requireNonNullElse(article, Article.NONE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
