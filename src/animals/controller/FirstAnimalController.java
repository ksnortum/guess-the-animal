package animals.controller;

import animals.logic.AnimalGetter;
import animals.model.Animal;

public class FirstAnimalController {
    private final AnimalGetter getter = new AnimalGetter();

    public Animal execute() {
        System.out.println("I want to learn about animals.");

        return getter.getAnimal("Which animal do you like most?");
    }
}
