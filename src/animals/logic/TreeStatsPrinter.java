package animals.logic;

import animals.model.Fact;
import animals.model.YesNoTree;
import animals.utils.TreeInfo;

public class TreeStatsPrinter {

    public void printStats(YesNoTree tree) {
        TreeInfo.TreeNumberStats numberStats = TreeInfo.getNumberStats(tree);
        TreeInfo.TreeDepthStats depthStats = TreeInfo.getDepthStats(tree);
        Fact fact = tree.getRoot().getFact();
        System.out.printf("- root node                    It %s %s%n",
                fact.getVerb().getPositiveForm(), fact.getFactText());
        System.out.printf("- total number of nodes        %d%n", numberStats.getNumberOfNodes());
        System.out.printf("- total number of animals      %d%n", numberStats.getNumberOfAnimals());
        System.out.printf("- total number of statements   %d%n", numberStats.getNumberOfFacts());
        System.out.printf("- height of the tree           %d%n", TreeInfo.heightOfTree(tree));
        System.out.printf("- minimum animal's depth       %d%n", depthStats.getMinimumDepth());
        System.out.printf("- average animal's depth       %s%n", depthStats.getAverageDepth());
    }
}
