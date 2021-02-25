package animals.controller;

import animals.logic.Greeter;
import animals.logic.Salutations;
import animals.model.Animal;
import animals.model.YesNoTree;

public class MainController {
    Greeter greeter = new Greeter();
    FirstAnimalController firstAnimalController = new FirstAnimalController();
    GameController gameController = new GameController();
    Salutations salutations = new Salutations();

    public void execute() {
        greeter.greeting();
        Animal firstAnimal = firstAnimalController.execute();
        YesNoTree tree = new YesNoTree();
        tree.firstAnimal(firstAnimal);
        boolean done = false;

        while (!done) {
            done = gameController.execute(tree);
        }

        salutations.goodbye();
    }
}
