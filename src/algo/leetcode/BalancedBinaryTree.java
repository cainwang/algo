package algo.leetcode;

import algo.model.TreeNode;


public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left(2);
        TreeNode right = root.right(3);
        right = right.right(4);
        right = right.right(5);

        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println(solution.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        int balance = checkDepth(root);
        System.out.println(balance);

        return balance != -1;
    }

    private int checkDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        int leftDepth = checkDepth(left);
        int rightDepth = checkDepth(right);

        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
