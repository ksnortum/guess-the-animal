package animals.logic;

import animals.model.TreeNode;
import animals.model.YesNoTree;

public class AnimalPrinter {
    public void printAnimals(YesNoTree tree) {
        System.out.println("Here are the animals I know:");
        printOneAnimal(tree.getRoot());
    }

    private void printOneAnimal(TreeNode node) {
        if (node.getNo() != null) {
            printOneAnimal(node.getNo());
        }

        if (node.hasAnAnimal()) {
            System.out.printf(" - %s%n", node.getAnimal().getName());
        }

        if (node.getYes() != null) {
            printOneAnimal(node.getYes());
        }
    }
}
