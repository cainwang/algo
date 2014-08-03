/**
 *
 */
package algo;

/**
 * @author Cain
 *
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode left(int val) {
        TreeNode node = new TreeNode(val);
        this.left = node;
        return node;
    }

    public TreeNode right(int val) {
        TreeNode node = new TreeNode(val);
        this.right = node;
        return node;
    }
}
