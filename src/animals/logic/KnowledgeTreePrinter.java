package animals.logic;

import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.utils.StringUtils;
import animals.view.KnowledgeTreePrinterView;

public class KnowledgeTreePrinter {
    private static final String CORNER = KnowledgeTreePrinterView.CORNER;
    private static final String BAR = KnowledgeTreePrinterView.BAR;
    private static final String BRANCH = KnowledgeTreePrinterView.BRANCH;

    private final KnowledgeTreePrinterView view = new KnowledgeTreePrinterView();

    public void printKnowledgeTree(YesNoTree tree) {
        printTreeHelper(tree.getRoot(), CORNER + " ");
    }

    private void printTreeHelper(TreeNode node, String printString) {
        if (node.hasAnAnimal()) {
            view.printAnimal(printString, node.getData());
            return;
        }

        view.printQuestion(printString, node.getData());
        printString = printString.substring(0, printString.length() - 1);

        if (printString.endsWith(CORNER)) {
            printString = printString.substring(0, printString.length() - 1) + " ";
        }

        printString = printString.replaceAll(BRANCH, BAR);
        printTreeHelper(node.getYes(), printString + BRANCH + " ");
        printTreeHelper(node.getNo(), printString + CORNER + " ");
    }
}
