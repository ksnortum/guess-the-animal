package animals.logic;

import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.view.AnimalPrinterView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalPrinter {
    private final AnimalPrinterView view = new AnimalPrinterView();

    public void printAnimals(YesNoTree tree) {
        view.printAnimalsIKnow();
        List<String> animals = new ArrayList<>();
        addAnimal(tree.getRoot(), animals);
        animals.sort(Comparator.naturalOrder());
        view.printAllAnimals(animals);
    }

    private void addAnimal(TreeNode node, List<String> animals) {
        if (node.getNo() != null) {
            addAnimal(node.getNo(), animals);
        }

        if (node.hasAnAnimal()) {
            animals.add(node.getData());
        }

        if (node.getYes() != null) {
            addAnimal(node.getYes(), animals);
        }
    }
}
