package animals.model;

public class YesNoTree {
    private TreeNode root;
    private TreeNode current;
    private boolean firstFact = true;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode resetTree() {
        current = root;
        return root;
    }

    public TreeNode getCurrent() {
        return current;
    }

    public void setCurrent(TreeNode current) {
        this.current = current;
    }

    public void firstAnimal(Animal animal) {
        current = new TreeNode(null, animal, null);
        root = current;
    }

    public void insert(Fact newFact, Animal newAnimal, boolean isYes) {
        if (current == null) {
            throw new IllegalStateException("You must call YesNoTree::firstAnimal(Animal) before insert");
        }

        TreeNode oldParent = current.getParent();
        TreeNode newFactNode = new TreeNode(newFact, null, current);
        TreeNode newAnimalNode = new TreeNode(null, newAnimal, newFactNode);
        current.setParent(newFactNode);

        if (isYes) {
            newFactNode.setNo(current);
            newFactNode.setYes(newAnimalNode);
        } else {
            newFactNode.setYes(current);
            newFactNode.setNo(newAnimalNode);
        }

        if (oldParent != null) {
            if (current.equals(oldParent.getYes())) {
                oldParent.setYes(newFactNode);
            } else {
                oldParent.setNo(newFactNode);
            }
        }

        if (newFact != null && firstFact) {
            root = newFactNode;
            firstFact = false;
        }
    }

    @Override
    public String toString() {
        return String.format("Tree{%n" +
                "root=%s, %n" +
                "current=%s, %n" +
                "firstFact=%s}", root, current, firstFact);
    }
}
