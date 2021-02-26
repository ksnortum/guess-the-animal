package animals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

public class YesNoTree {
    private Node root;
    private Node current;
    private boolean firstFact = true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Node {
        private Fact fact;
        private Animal animal;
        private Node parent;
        private Node yes;
        private Node no;

        public Node() {
            this(null, null, null);
        }

        public Node(Fact fact, Animal animal, Node parent) {
            this.fact = fact;
            this.animal = animal;
            this.parent = parent;
            this.yes = null;
            this.no = null;
        }

        public Fact getFact() {
            return fact;
        }

        public void setFact(Fact fact) {
            this.fact = fact;
        }

        public Animal getAnimal() {
            return animal;
        }

        public void setAnimal(Animal animal) {
            this.animal = animal;
        }

        public Node getYes() {
            return yes;
        }

        public void setYes(Node yes) {
            this.yes = yes;
        }

        public Node getNo() {
            return no;
        }

        public void setNo(Node no) {
            this.no = no;
        }

        @JsonIgnore
        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        @JsonIgnore
        public boolean isQuestion() {
            return fact != null;
        }

        @JsonIgnore
        public boolean isAnimal() {
            return !isQuestion();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;

            return Objects.equals(fact, node.fact) && Objects.equals(animal, node.animal);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fact, animal);
        }

        @Override
        public String toString() {
            return String.format("Node{fact=%s, animal=%s, parent=%s, yes=%s, no=%s}",
                    fact,
                    animal,
                    parent == null ? "null" : "notNull",
                    yes == null ? "null" : yes.toString(),
                    no == null ? "null" : no.toString());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node resetTree() {
        current = root;
        return root;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    public void firstAnimal(Animal animal) {
        current = new Node(null, animal, null);
        root = current;
    }

    public void insert(Fact newFact, Animal newAnimal, boolean isYes) {
        if (current == null) {
            throw new IllegalStateException("You must call YesNoTree::firstAnimal(Animal) before insert");
        }

        Node oldParent = current.getParent();
        Node newFactNode = new Node(newFact, null, current);
        Node newAnimalNode = new Node(null, newAnimal, newFactNode);
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
