package animals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeNode {
    private Fact fact;
    private Animal animal;
    private TreeNode parent;
    private TreeNode yes;
    private TreeNode no;

    public TreeNode() {
        this(null, null, null);
    }

    public TreeNode(Fact fact, Animal animal, TreeNode parent) {
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

    public TreeNode getYes() {
        return yes;
    }

    public void setYes(TreeNode yes) {
        this.yes = yes;
    }

    public TreeNode getNo() {
        return no;
    }

    public void setNo(TreeNode no) {
        this.no = no;
    }

    @JsonIgnore
    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
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
        TreeNode node = (TreeNode) o;

        return Objects.equals(fact, node.fact) && Objects.equals(animal, node.animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fact, animal);
    }

    @Override
    public String toString() {
        return String.format("TreeNode{fact=%s, animal=%s, parent=%s, yes=%s, no=%s}",
                fact,
                animal,
                parent == null ? "null" : "notNull",
                yes == null ? "null" : yes.toString(),
                no == null ? "null" : no.toString());
    }
}