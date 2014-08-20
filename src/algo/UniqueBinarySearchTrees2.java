/**
 *
 */
package algo;

import java.util.LinkedList;
import java.util.List;

import algo.model.TreeNode;

/**
 * @author cainwang
 *
 */
public class UniqueBinarySearchTrees2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UniqueBinarySearchTrees2 solution = new UniqueBinarySearchTrees2();
        List<TreeNode> result = solution.generateTrees(3);
        System.out.println(result);
    }

    public List<TreeNode> generateTrees(int n) {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i ++) {
            list.add(i);
        }

        return doGenerate(list);
    }

    private List<TreeNode> doGenerate(List<Integer> list) {
        List<TreeNode> result = new LinkedList<>();

        if (list == null || list.isEmpty()) {
            result.add(null);
        } else if (list.size() == 1) {
            TreeNode node = new TreeNode(list.get(0));
            result.add(node);
        } else {
            for (int i = 0; i < list.size(); i ++) {
                int num = list.get(i);

                List<Integer> leftList = list.subList(0, i);
                List<Integer> rightList = list.subList(i + 1, list.size());

                List<TreeNode> leftTrees = doGenerate(leftList);
                List<TreeNode> rightTrees = doGenerate(rightList);

                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree: rightTrees) {
                        TreeNode currentRoot = new TreeNode(num);
                        currentRoot.left = leftTree;
                        currentRoot.right = rightTree;

                        result.add(currentRoot);
                    }
                }
            }
        }

        return result;
    }
}
