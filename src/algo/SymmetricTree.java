package algo;

import algo.model.TreeNode;


public class SymmetricTree {

    public static void main(String[] args) {
    }

    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return checkSymmetrics(root.left, root.right);
        }

        return true;
    }

    public boolean checkSymmetrics(TreeNode current, TreeNode mirror) {
        if (current == null && mirror == null) {
            return true;
        } else if (current == null || mirror == null) {
            return false;
        }

        if (current.val != mirror.val) {
            return false;
        }

        boolean leftMatched = checkSymmetrics(current.left, mirror.right);
        boolean rightMatched = checkSymmetrics(current.right, mirror.left);

        return leftMatched && rightMatched;
    }
}
