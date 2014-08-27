/**
 *
 */
package algo.leetcode;

import algo.model.TreeNode;

/**
 * @author cainwang
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inorder = { -4, -10, 3, -1, 7, 11, -8, 2 };
        int[] postorder = { -4, -1, 3, -10, 11, -8, 2, 7 };

        ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode result = solution.buildTree(inorder, postorder);

        System.out.println(result);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }

        TreeNode root = build(inorder, 0, inorder.length, postorder, 0, postorder.length);

        return root;
    }

    private TreeNode build(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart,
            int postorderEnd) {
        if (inorderStart == inorderEnd || postorderStart == postorderEnd) {
            return null;
        }

        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);

        int inorderRootIndex = find(inorder, rootVal);
        int leftTreeLength = inorderRootIndex - inorderStart;

        root.left = build(inorder, inorderStart, inorderRootIndex, postorder, postorderStart, postorderStart
                + leftTreeLength);
        root.right = build(inorder, inorderRootIndex + 1, inorderEnd, postorder, postorderStart + leftTreeLength,
                postorderEnd - 1);

        return root;
    }

    private int find(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return i;
            }
        }

        return -1;
    }
}
