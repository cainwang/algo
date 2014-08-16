/**
 *
 */
package algo;

import algo.model.TreeNode;


/**
 * @author cainwang
 *
 */
public class MinimumDepthOfBinaryTree {
    private int minDepth = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();
        int depth = solution.minDepth(node);
        System.out.println(depth);
    }

    public int minDepth(TreeNode root) {
        checkDepth(root, 0);
        return minDepth;
    }

    private void checkDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        depth ++;

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left == null && right == null) {
            if (depth < minDepth || minDepth == 0) {
                minDepth = depth;
            }
        } else if (depth < minDepth || minDepth == 0) {
            checkDepth(left, depth);
            checkDepth(right, depth);
        }
    }
}
