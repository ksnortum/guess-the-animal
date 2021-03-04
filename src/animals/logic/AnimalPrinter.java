package animals.logic;

import animals.model.Animal;
import animals.model.TreeNode;
import animals.model.YesNoTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalPrinter {
    public void printAnimals(YesNoTree tree) {
        System.out.println("Here are the animals I know:");
        List<String> animals = new ArrayList<>();
        printOneAnimal(tree.getRoot(), animals);
        animals.sort(Comparator.naturalOrder());
        animals.forEach(animal -> System.out.printf(" - %s%n", animal));
    }

    private void printOneAnimal(TreeNode node, List<String> animals) {
        if (node.getNo() != null) {
            printOneAnimal(node.getNo(), animals);
        }

        if (node.hasAnAnimal()) {
            animals.add(node.getAnimal().getName());
        }

        if (node.getYes() != null) {
            printOneAnimal(node.getYes(), animals);
        }
    }
}
