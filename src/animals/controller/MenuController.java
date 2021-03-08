package animals.controller;

import animals.logic.AnimalPrinter;
import animals.logic.AnimalSearcher;
import animals.logic.KnowledgeTreePrinter;
import animals.logic.TreeStatsPrinter;
import animals.model.YesNoTree;
import animals.utils.Inputer;
import animals.view.MenuView;

public class MenuController {
    MenuView menuView = new MenuView();
    GameController gameController = new GameController();
    AnimalPrinter animalPrinter = new AnimalPrinter();
    AnimalSearcher animalSearcher = new AnimalSearcher();
    TreeStatsPrinter treeStatsPrinter = new TreeStatsPrinter();
    KnowledgeTreePrinter knowledgeTreePrinter = new KnowledgeTreePrinter();

    public void execute(YesNoTree tree) {
        int response = 1; // any non-zero number

        while (response != 0) {
            menuView.printMenu();
            response = Inputer.nextInt("");

            switch(response) {
                case 1:
                    gameController.execute(tree);
                    break;
                case 2:
                    animalPrinter.printAnimals(tree);
                    break;
                case 3:
                    animalSearcher.searchForAnimal(tree);
                    break;
                case 4:
                    treeStatsPrinter.printStats(tree);
                    break;
                case 5:
                    knowledgeTreePrinter.printKnowledgeTree(tree);
                    break;
                case 0:
                    break;
                default:
                    menuView.badOption();
            }
        }
    }
}
