package animals.utils;

import animals.model.TreeNode;
import animals.model.YesNoTree;

import java.util.ArrayList;
import java.util.List;

public class TreeInfo {
    public static class TreeNumberStats {
        private int numberOfNodes = 0;
        private int numberOfAnimals = 0;
        private int numberOfFacts = 0;

        public void incrementNodes() {
            numberOfNodes++;
        }

        public void incrementAnimals() {
            numberOfAnimals++;
        }

        public void incrementFacts() {
            numberOfFacts++;
        }

        public int getNumberOfNodes() {
            return numberOfNodes;
        }

        public int getNumberOfAnimals() {
            return numberOfAnimals;
        }

        public int getNumberOfFacts() {
            return numberOfFacts;
        }
    }

    public static class TreeDepthStats {
        private final List<Integer> heightList = new ArrayList<>();

        public double getAverageDepth() {
            if (heightList.size() == 0) {
                return 0;
            }

            return heightList.stream().mapToDouble(i -> i).sum() / heightList.size();
        }

        public int getMinimumDepth() {
            return heightList.stream()
                    .mapToInt(i -> i)
                    .min()
                    .orElse(0);
        }

        public void add(int height) {
            heightList.add(height);
        }
    }

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
            return noHeight + 1;
        } else {
            return yesHeight + 1;
        }
    }

    public static TreeNumberStats getNumberStats(YesNoTree tree) {
        TreeNumberStats stats = new TreeNumberStats();
        countStats(tree.getRoot(), stats);

        return stats;
    }

    private static void countStats(TreeNode node, TreeNumberStats stats) {
        if (node.hasAnAnimal()) {
            stats.incrementAnimals();
            stats.incrementNodes();
            return;
        }

        countStats(node.getYes(), stats);
        countStats(node.getNo(), stats);
        stats.incrementFacts();
        stats.incrementNodes();
    }

    public static TreeDepthStats getDepthStats(YesNoTree tree) {
        TreeDepthStats stats = new TreeDepthStats();
        depthStats(tree.getRoot(), stats, 0);

        return stats;
    }

    private static void depthStats(TreeNode node, TreeDepthStats stats, int depth) {
        if (node.hasAnAnimal()) {
            stats.add(depth + 1);

            return;
        }

        depthStats(node.getYes(), stats, depth + 1);
        depthStats(node.getNo(), stats, depth + 1);
    }
}
