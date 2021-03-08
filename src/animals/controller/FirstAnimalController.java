package animals.controller;

import animals.logic.AnimalGetter;
import animals.view.FirstAnimalControllerView;

public class FirstAnimalController {
    private final AnimalGetter getter = new AnimalGetter();
    private final FirstAnimalControllerView view = new FirstAnimalControllerView();

    public String execute() {
        view.printWantToLearn();

        return getter.getAnimal(view.getAskFavorite());
    }
}
