/**
 *
 */
package algo;

/**
 * @author cainwang
 *
 */
public class PathSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left(2);
        root.right(3);

        PathSum solution = new PathSum();
        System.out.println(solution.hasPathSum(root, 4));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return findSum(root, sum, 0);
    }

    private boolean findSum(TreeNode node, int targetSum, int currentSum) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        currentSum += node.val;

        if (left == null && right == null) {
            if (currentSum == targetSum) {
                return true;
            }
        } else {
            if (left != null) {
                if (findSum(left, targetSum, currentSum)) {
                    return true;
                }
            }
            if (right != null) {
                if (findSum(right, targetSum, currentSum)) {
                    return true;
                }
            }
        }

        return false;
    }
}
