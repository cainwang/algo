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
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> results = solution.zigzagLevelOrder(root);
        System.out.println(results);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();

        if (root == null) {
            return results;
        }

        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        boolean leftToRight = true;

        while (!nodes.isEmpty()) {
            List<Integer> result = new LinkedList<>();
            results.add(result);

            List<TreeNode> nextLevel = new LinkedList<>();

            for (TreeNode node : nodes) {
                if (leftToRight) {
                    result.add(node.val);
                } else {
                    result.add(0, node.val);
                }

                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            nodes = nextLevel;
            leftToRight = !leftToRight;
        }

        return results;
    }
}
