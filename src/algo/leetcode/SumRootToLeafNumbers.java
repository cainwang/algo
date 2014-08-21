/**
 *
 */
package algo.leetcode;

import algo.model.TreeNode;


/**
 * @author cainwang
 *
 */
public class SumRootToLeafNumbers {
    private int sum = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        doSum(root, 0);
        return sum;
    }

    private void doSum(TreeNode root, int num) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        num = num * 10 + root.val;

        if (left == null && right == null) {
            sum += num;
        }

        if (left != null) {
            doSum(left, num);
        }
        if (right != null) {
            doSum(right, num);
        }
    }
}
