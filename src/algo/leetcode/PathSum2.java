/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

import algo.model.TreeNode;

/**
 * @author cainwang
 *
 */
public class PathSum2 {
    private List<List<Integer>> results = new LinkedList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right(-3);

        PathSum2 solution = new PathSum2();
        solution.pathSum(root, -5);

        System.out.println(solution.results);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            traverse(root, new LinkedList<Integer>(), 0, sum);
        }

        return results;
    }

    private void traverse(TreeNode node, List<Integer> result, int sum, int targetSum) {
        if (node == null) {
            return;
        }

        int val = node.val;
        sum += val;
        result.add(val);

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left == null && right == null) {
            if (sum == targetSum) {
                results.add(result);
            }
        } else {
            traverse(left, new LinkedList<Integer>(result), sum, targetSum);
            traverse(right, new LinkedList<Integer>(result), sum, targetSum);
        }
    }
}
