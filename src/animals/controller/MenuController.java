package animals.controller;

import animals.logic.AnimalPrinter;
import animals.logic.AnimalSearcher;
import animals.logic.KnowledgeTreePrinter;
import animals.logic.TreeStatsPrinter;
import animals.model.YesNoTree;
import animals.utils.Inputer;

public class MenuController {
    GameController gameController = new GameController();
    AnimalPrinter animalPrinter = new AnimalPrinter();
    AnimalSearcher animalSearcher = new AnimalSearcher();
    TreeStatsPrinter treeStatsPrinter = new TreeStatsPrinter();
    KnowledgeTreePrinter knowledgeTreePrinter = new KnowledgeTreePrinter();

    public void execute(YesNoTree tree) {
        int response = 1; // any non-zero number

        while (response != 0) {
            printMenu();
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
                    System.out.println("You must enter a number between 0 and 5");
            }
        }

    }

    private void printMenu() {
        System.out.println();
        System.out.println("What do you want to do:");
        System.out.println();
        System.out.println("1. Play the guessing game");
        System.out.println("2. List of all animals");
        System.out.println("3. Search for an animal");
        System.out.println("4. Calculate statistics");
        System.out.println("5. Print the Knowledge Tree");
        System.out.println("0. Exit");
    }
}
