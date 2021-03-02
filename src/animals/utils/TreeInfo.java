package animals.utils;

import animals.model.TreeNode;
import animals.model.YesNoTree;

public class TreeInfo {
    public static int heightOfTree(YesNoTree tree) {
        return heightHelper(tree.getRoot());
    }

    private static int heightHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int noHeight = heightHelper(node.getNo());
        int yesHeight = heightHelper(node.getYes());

        if (noHeight > yesHeight) {
            return (noHeight + 1);
        } else {
            return(yesHeight + 1);
        }
    }
}
