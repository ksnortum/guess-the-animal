package animals.logic;

import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.view.AnimalSearcherView;

public class AnimalSearcher {
    private final AnimalGetter getter = new AnimalGetter();
    private final AnimalSearcherView view = new AnimalSearcherView();

    // TODO do this without searching several times.  Maybe with a queue?
    public void searchForAnimal(YesNoTree tree) {
        String searchAnimal = getter.getAnimal(view.getEnterTheAnimal());

        if (foundAnimalOnThisBranch(tree.getRoot(), searchAnimal)) {
            view.printFactsAbout(searchAnimal);
            doAnimalSearch(tree.getRoot(), searchAnimal);
        } else {
            view.printNoFactsAbout(searchAnimal);
        }
    }

    private void doAnimalSearch(TreeNode node, String searchAnimal) {
        if (node.hasAnAnimal()) {
            return;
        }

        String fact = node.getData();

        if (foundAnimalOnThisBranch(node.getYes(), searchAnimal)) {
            view.printPositiveFact(fact);
            doAnimalSearch(node.getYes(), searchAnimal);
        }

        if (foundAnimalOnThisBranch(node.getNo(), searchAnimal)) {
            view.printNegativeFact(fact);
            doAnimalSearch(node.getNo(), searchAnimal);
        }
    }

    private boolean foundAnimalOnThisBranch(TreeNode node, String searchAnimal) {
        if (node.hasAnAnimal()) {
            return searchAnimal.equals(node.getData());
        }

        return foundAnimalOnThisBranch(node.getYes(), searchAnimal) ||
                foundAnimalOnThisBranch(node.getNo(), searchAnimal);
    }
}
