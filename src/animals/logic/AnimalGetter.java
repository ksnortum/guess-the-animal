package animals.logic;

import animals.utils.Inputer;
import animals.utils.LanguageRules;
import animals.view.AnimalGetterView;

public class AnimalGetter {
    private final AnimalGetterView view = new AnimalGetterView();

    public String getAnimal(String prompt) {
        boolean done = false;
        String animal = "";

        while(!done) {
            animal = Inputer.nextString(prompt);

            if (LanguageRules.isAnimalCorrect(animal)) {
                animal = LanguageRules.prepareAnimal(animal);
                done = true;
            } else {
                view.printAnimalError();
            }
        }

        return animal;
    }
}
