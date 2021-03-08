package animals.model;

public class YesNoTree {
    private TreeNode root;
    private TreeNode current;
    private boolean firstFact;

    public YesNoTree() {
        root = null;
        current = null;
        firstFact = true;
    }

    public YesNoTree(TreeNode root) {
        this.root = root;
        current = root;
        firstFact = false;
    }

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

    public void firstAnimal(String animal) {
        root = new TreeNode(animal, null);
        current = root;
    }

    public void insert(String newFact, String newAnimal, boolean isYes) {
        if (current == null) {
            throw new IllegalStateException("You must call YesNoTree::firstAnimal(Animal) before insert");
        }

        if (newFact == null || newAnimal == null) {
            throw new IllegalArgumentException("Neither newFact nor newAnimal can be null");
        }

        TreeNode oldParent = current.getParent();
        TreeNode newFactNode = new TreeNode(newFact, oldParent);
        TreeNode newAnimalNode = new TreeNode(newAnimal, newFactNode);
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

        if (firstFact) {
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
