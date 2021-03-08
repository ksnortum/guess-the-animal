package animals.logic;

import animals.model.YesNoTree;
import animals.utils.TreeInfo;
import animals.view.TreeStatsPrinterView;

public class TreeStatsPrinter {
    private final TreeStatsPrinterView view = new TreeStatsPrinterView();

    public void printStats(YesNoTree tree) {
        view.printTitle();
        TreeInfo.TreeNumberStats numberStats = TreeInfo.getNumberStats(tree);
        TreeInfo.TreeDepthStats depthStats = TreeInfo.getDepthStats(tree);
        String fact = tree.getRoot().getData();
        view.printRoot(fact);
        view.printNodes(numberStats.getNumberOfNodes());
        view.printAnimals(numberStats.getNumberOfAnimals());
        view.printStatements(numberStats.getNumberOfFacts());
        view.printHeight(TreeInfo.heightOfTree(tree) - 1);
        view.printMinimum(depthStats.getMinimumDepth());
        view.printAverage(depthStats.getAverageDepth());
    }
}
