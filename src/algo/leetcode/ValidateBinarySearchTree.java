/**
 *
 */
package algo.leetcode;

import algo.model.TreeNode;

/**
 * @author Cain
 *
 */
public class ValidateBinarySearchTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left(5);
        TreeNode node = root.right(15);
        node.left(6);
        node.right(20);

        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        boolean result = solution.isValidBST(root);

        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode node, int lowRange, int highRange) {
        int val = node.val;

        if (val <= lowRange || val >= highRange) {
            return false;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left != null) {
            if (!checkBST(left, lowRange, Math.min(val, highRange))) {
                return false;
            }
        }
        if (right != null) {
            if (!checkBST(right, Math.max(val, lowRange), highRange)) {
                return false;
            }

        }

        return true;
    }
}
