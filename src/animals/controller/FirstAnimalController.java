package animals.controller;

import animals.logic.AnimalGetter;
import animals.model.Animal;

public class FirstAnimalController {
    private final AnimalGetter getter = new AnimalGetter();

    public Animal execute() {
        System.out.println("I want to learn about animals.");
        Animal animal = getter.getAnimal("Which animal do you like most?");
        System.out.println("Wonderful! I've learned so much about animals!");
        System.out.println("Let's play a game!");

        return animal;
    }
}
