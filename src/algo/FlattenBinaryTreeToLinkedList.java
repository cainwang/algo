/**
 *
 */
package algo;

import algo.model.TreeNode;

/**
 * @author Cain
 *
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root.left(2);
        node.left(3);
        node.right(4);

        root.right(5).right(6);

        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);

        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        doFlatten(root);
    }

    private TreeNode doFlatten(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left == null && right == null) {
            return node;
        } else {
            TreeNode leftTail = null;
            if (left != null) {
                leftTail = doFlatten(left);
            }

            if (right == null) {
                node.right = left;
                node.left = null;

                return leftTail;
            } else {
                TreeNode rightTail = doFlatten(right);

                if (left != null) {
                    leftTail.right = right;
                    node.right = left;
                    node.left = null;
                }

                return rightTail;
            }
        }
    }
}
