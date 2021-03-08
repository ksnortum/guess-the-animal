package animals.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Objects;

@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeNode {
    private String data;
    private TreeNode parent;
    private TreeNode yes;
    private TreeNode no;

    public TreeNode() {
        this(null, null);
    }

    public TreeNode(String data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
        this.yes = null;
        this.no = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @JsonIgnore
    public boolean hasAnAnimal() {
        return yes == null && no == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;

        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return String.format("TreeNode{data=%s, parent=%s, yes=%s, no=%s}",
                data,
                parent == null ? "null" : parent.getData(),
                yes == null ? "null" : yes.toString(),
                no == null ? "null" : no.toString());
    }
}