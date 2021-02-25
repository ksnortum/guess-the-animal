package animals.controller;

import animals.logic.AnimalGetter;
import animals.logic.AnimalDistinguisher;
import animals.model.Animal;
import animals.model.YesNoTree;
import animals.utils.Inputer;

public class GameController {
    private final AnimalDistinguisher distinguisher = new AnimalDistinguisher();
    private final AnimalGetter getter = new AnimalGetter();

    public boolean execute(YesNoTree tree) {
        System.out.println("You think of an animal, and I guess it.");
        Inputer.pause("Press enter when you're ready.");
        YesNoTree.Node current = tree.resetTree();
        boolean done = false;
        boolean exitGame = false;

        while (!done) {
            if (current.isAnimal()) {
                Animal animal = current.getAnimal();
                String prompt = String.format("Is it %s?", animal);
                boolean isYes = Inputer.nextYesNo(prompt);

                if (isYes) {
                    System.out.println("Yay!  I guessed it!");
                } else {
                    Animal correctAnimal = getter.getAnimal("I give up. What animal do you have in mind?");
                    distinguisher.distinguish(animal, correctAnimal, tree);
                }

                System.out.println();
                isYes = Inputer.nextYesNo("Would you like to play again?");
                exitGame = !isYes;
                done = true;
            } else { // current node is a question
                boolean isYes = Inputer.nextYesNo(current.getFact().getQuestion());

                if (isYes) {
                    tree.setCurrent(current.getYes());
                } else {
                    tree.setCurrent(current.getNo());
                }

                current = tree.getCurrent();
            }
        }

        return exitGame;
    }
}
