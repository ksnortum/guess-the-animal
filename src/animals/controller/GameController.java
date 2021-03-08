package animals.controller;

import animals.logic.AnimalGetter;
import animals.logic.AnimalDistinguisher;
import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.utils.Inputer;
import animals.utils.LanguageRules;
import animals.view.GameControllerView;

public class GameController {
    private final AnimalDistinguisher distinguisher = new AnimalDistinguisher();
    private final AnimalGetter getter = new AnimalGetter();
    private final GameControllerView view = new GameControllerView();

    public void execute(YesNoTree tree) {
        view.printLetsPlay();
        boolean playGame = true;

        while(playGame) {
            view.printThinkOfAnAnimal();
            Inputer.pause(view.getEnterPrompt());
            TreeNode current = tree.resetTree();
            boolean done = false;

            while (!done) {
                if (current.hasAnAnimal()) {
                    guessAnimal(tree, current);
                    System.out.println();
                    playGame = Inputer.nextYesNo(view.getGameAgain());
                    done = true;
                } else {
                    current = askQuestion(tree, current);
                }
            }
        }
    }

    private TreeNode askQuestion(YesNoTree tree, TreeNode current) {
        boolean isYes = Inputer.nextYesNo(view.getQuestion(current.getData()));

        if (isYes) {
            tree.setCurrent(current.getYes());
        } else {
            tree.setCurrent(current.getNo());
        }

        return tree.getCurrent();
    }

    private void guessAnimal(YesNoTree tree, TreeNode current) {
        String animal = current.getData();
        String prompt = LanguageRules.prepareGuessAnimal(animal);
        boolean isYes = Inputer.nextYesNo(prompt);

        if (isYes) {
            view.printGameWin();
        } else {
            String correctAnimal = getter.getAnimal(view.getGiveUp());
            distinguisher.distinguish(animal, correctAnimal, tree);
        }
    }
}
