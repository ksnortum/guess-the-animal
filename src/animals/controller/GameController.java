package animals.controller;

import animals.logic.AnimalGetter;
import animals.logic.AnimalDistinguisher;
import animals.model.Animal;
import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.utils.Inputer;

public class GameController {
    private final AnimalDistinguisher distinguisher = new AnimalDistinguisher();
    private final AnimalGetter getter = new AnimalGetter();

    public void execute(YesNoTree tree) {
        boolean playGame = true;

        while(playGame) {
            System.out.println("You think of an animal, and I guess it.");
            Inputer.pause("Press enter when you're ready.");
            TreeNode current = tree.resetTree();
            boolean done = false;

            while (!done) {
                if (current.hasAnAnimal()) {
                    guessAnimal(tree, current);
                    System.out.println();
                    playGame = Inputer.nextYesNo("Do you like to play again?");
                    done = true;
                } else {
                    current = askQuestion(tree, current);
                }
            }
        }
    }

    private TreeNode askQuestion(YesNoTree tree, TreeNode current) {
        boolean isYes = Inputer.nextYesNo(current.getFact().getQuestion());

        if (isYes) {
            tree.setCurrent(current.getYes());
        } else {
            tree.setCurrent(current.getNo());
        }

        return tree.getCurrent();
    }

    private void guessAnimal(YesNoTree tree, TreeNode current) {
        Animal animal = current.getAnimal();
        String prompt = String.format("Is it %s?", animal);
        boolean isYes = Inputer.nextYesNo(prompt);

        if (isYes) {
            System.out.println("Yay!  I guessed it!");
        } else {
            Animal correctAnimal = getter.getAnimal("I give up. What animal do you have in mind?");
            distinguisher.distinguish(animal, correctAnimal, tree);
        }
    }
}
