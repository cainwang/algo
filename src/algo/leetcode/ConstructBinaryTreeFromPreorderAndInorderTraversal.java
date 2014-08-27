/**
 *
 */
package algo.leetcode;

import algo.model.TreeNode;

/**
 * @author cainwang
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] preOrder = {1, 2};
        int[] inOrder = {2, 1};

        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode result = solution.buildTree(preOrder, inOrder);

        System.out.println(result);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }

        return build(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
    }

    private TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }

        int rootVal = preOrder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inOrderRootIndex = find(inOrder, rootVal);
        int leftTreeLength = inOrderRootIndex - inStart;

        root.left = build(preOrder, preStart + 1, preStart + 1 + leftTreeLength, inOrder, inStart, inOrderRootIndex);
        root.right = build(preOrder, preStart + leftTreeLength + 1, preEnd, inOrder, inOrderRootIndex + 1, inEnd);

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
