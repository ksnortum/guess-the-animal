package animals.logic;

import animals.model.Animal;
import animals.model.Article;
import animals.utils.Inputer;

public class AnimalGetter {
    public Animal getAnimal(String prompt) {
        String animalPhrase = "";

        while (animalPhrase.isBlank()) {
            animalPhrase = Inputer.nextString(prompt);
        }

        animalPhrase = animalPhrase.strip();
        Article article = Article.parseArticle(animalPhrase);
        String animalName = Article.stripArticle(animalPhrase);

        return new Animal(animalName, article);
    }
}
