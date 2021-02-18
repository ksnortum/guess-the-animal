package animals.controller;

import animals.logic.AnimalConfirmer;
import animals.logic.AnimalDistinguisher;
import animals.logic.Greeter;
import animals.logic.Salutations;
import animals.model.Animal;

public class MainController {
    Greeter greeter = new Greeter();
    AnimalConfirmer confirmer = new AnimalConfirmer();
    AnimalDistinguisher distinguisher = new AnimalDistinguisher();
    Salutations salutations = new Salutations();

    public void execute() {
        greeter.greeting();
        Animal firstAnimal = confirmer.getAnimal("first");
        Animal secondAnimal = confirmer.getAnimal("second");
        distinguisher.distinguish(firstAnimal, secondAnimal);
        salutations.goodbye();
    }
}
