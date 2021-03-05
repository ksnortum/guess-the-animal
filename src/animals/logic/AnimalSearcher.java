package animals.logic;

import animals.model.Animal;
import animals.model.Fact;
import animals.model.TreeNode;
import animals.model.YesNoTree;

public class AnimalSearcher {
    private final AnimalGetter getter = new AnimalGetter();

    // TODO do this without searching several times.  Maybe with a queue?
    public void searchForAnimal(YesNoTree tree) {
        Animal searchAnimal = getter.getAnimal("Enter the animal:");

        if (foundAnimalOnThisBranch(tree.getRoot(), searchAnimal)) {
            System.out.printf("Facts about the %s:%n", searchAnimal.getName());
            doAnimalSearch(tree.getRoot(), searchAnimal);
        } else {
            System.out.printf("No facts about the %s.%n", searchAnimal.getName());
        }
    }

    private void doAnimalSearch(TreeNode node, Animal searchAnimal) {
        if (node.hasAnAnimal()) {
            return;
        }

        Fact fact = node.getFact();

        if (foundAnimalOnThisBranch(node.getYes(), searchAnimal)) {
            System.out.printf(" - It %s %s.%n", fact.getVerb().getPositiveForm(), fact.getFactText());
            doAnimalSearch(node.getYes(), searchAnimal);
        }

        if (foundAnimalOnThisBranch(node.getNo(), searchAnimal)) {
            System.out.printf(" - It %s %s.%n", fact.getVerb().getNegativeForm(), fact.getFactText());
            doAnimalSearch(node.getNo(), searchAnimal);
        }
    }

    private boolean foundAnimalOnThisBranch(TreeNode node, Animal searchAnimal) {
        if (node.hasAnAnimal()) {
            return searchAnimal.equals(node.getAnimal());
        }

        return foundAnimalOnThisBranch(node.getYes(), searchAnimal) ||
                foundAnimalOnThisBranch(node.getNo(), searchAnimal);
    }
}