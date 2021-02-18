package animals.logic;

import animals.model.Animal;
import animals.model.Article;
import animals.model.ClarifyingPhrase;
import animals.utils.Inputer;

public class AnimalConfirmer {
    public Animal getAnimal() {
        String animalPhrase = Inputer.nextString("Please enter an animal: ");

        if (animalPhrase.isBlank()) {
            return new Animal();
        }

        animalPhrase = animalPhrase.strip();
        Article article = Article.parseArticle(animalPhrase);
        String animalName = Article.stripArticle(animalPhrase);

        return new Animal(animalName, article);
    }

    public void confirmAnimal(Animal animal) {
        String prompt = String.format("Is it %s %s?",
                animal.getArticle().getWord(), animal.getName());
        String response = Inputer.nextString(prompt);
        boolean isYes = Response.parseYes(response);
        boolean isNo = Response.parseNo(response);

        while (!isYes && !isNo) {
            prompt = ClarifyingPhrase.nextPhrase();
            response = Inputer.nextString(prompt);
            isYes = Response.parseYes(response);
            isNo = Response.parseNo(response);
        }

        if (isYes) {
            System.out.println("You answered: Yes");
        } else {
            System.out.println("You answered: No");
        }
    }
}
