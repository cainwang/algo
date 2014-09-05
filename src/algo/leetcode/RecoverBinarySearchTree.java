/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

import algo.model.TreeNode;

/**
 * @author Cain
 *
 */
public class RecoverBinarySearchTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(146);
        TreeNode left = root.left(71);
        TreeNode right = root.right(-13);

        left.left(55).left(321);
        right.left(231);
        right.right(399);

        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();
        solution.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> results = new LinkedList<TreeNode>();
        List<TreeNode> queue = new LinkedList<TreeNode>();

        traverse(root, queue, results);

        if (results.size() < 2) {
            results.add(queue.get(queue.size() - 1));
        }

        if (results.size() == 2) {
            int swap = results.get(0).val;
            results.get(0).val = results.get(1).val;
            results.get(1).val = swap;
        }
    }

    private void traverse(TreeNode node, List<TreeNode> queue, List<TreeNode> results) {
        if (node == null) {
            return;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        traverse(left, queue, results);
        check(node, queue, results);
        traverse(right, queue, results);
    }

    private void check(TreeNode node, List<TreeNode> queue, List<TreeNode> results) {
        int size = queue.size();
        int val = node.val;

        if (size == 1) {
            TreeNode first = queue.get(0);
            if (first.val > val) {
                results.add(first);
            }
        }

        if (size >= 3) {
            queue.remove(0);
        }

        if (size >= 2) {
            TreeNode first = queue.get(0);
            TreeNode second = queue.get(1);

            if (((second.val < Math.min(first.val, val)) || (second.val > Math.max(first.val, val))) && first.val < val) {
                results.add(second);
            }
        }

        queue.add(node);
    }
}
