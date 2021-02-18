package animals.controller;

import animals.logic.AnimalConfirmer;
import animals.logic.Greeter;
import animals.logic.Salutations;
import animals.model.Animal;

public class MainController {
    Greeter greeter = new Greeter();
    AnimalConfirmer confirmer = new AnimalConfirmer();
    Salutations salutations = new Salutations();

    public void execute() {
        greeter.greeting();
        Animal animal = confirmer.getAnimal();
        confirmer.confirmAnimal(animal);
        salutations.goodbye();
    }
}
