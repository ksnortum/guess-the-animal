package animals.logic;

import animals.model.Fact;
import animals.model.TreeNode;
import animals.model.YesNoTree;
import animals.utils.StringUtils;

public class KnowledgeTreePrinter {
    private static final String CLOSE = "└";
    private static final String BAR = "│";
    private static final String INTERSECTION = "├";

    public void printKnowledgeTree(YesNoTree tree) {
        printTreeHelper(tree.getRoot(), CLOSE + " ");
    }

    private void printTreeHelper(TreeNode node, String printString) {
        if (node.hasAnAnimal()) {
            System.out.printf("%s%s%n", printString, node.getAnimal());
            return;
        }

        Fact fact = node.getFact();
        String question = String.format("%s %s?",
                fact.getVerb().getQuestionForm(), fact.getFactText());
        question = StringUtils.properCase(question);
        System.out.printf("%s%s%n", printString, question);
        printString = printString.substring(0, printString.length() - 1);

        if (printString.endsWith(CLOSE)) {
            printString = printString.substring(0, printString.length() - 1) + " ";
        }

        printString = replaceIntersectionWithBar(printString);
        printTreeHelper(node.getYes(), printString + INTERSECTION + " ");
        printTreeHelper(node.getNo(), printString + CLOSE + " ");
    }

    private String replaceIntersectionWithBar(String printString) {
        int index = printString.indexOf(INTERSECTION);

        while (index != -1) {
            printString = printString.substring(0, index) + BAR + printString.substring(index + 1);
            index = printString.indexOf(INTERSECTION);
        }

        return printString;
    }
}
