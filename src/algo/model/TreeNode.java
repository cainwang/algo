/**
 *
 */
package algo.model;

/**
 * @author Cain
 *
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
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

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
