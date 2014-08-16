/**
 *
 */
package algo.model;

/**
 * @author cainwang
 *
 */
public class TreeLinkNode {
    public TreeLinkNode next;

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;

    public TreeLinkNode(int x) {
        val = x;
    }

    public TreeLinkNode left(int val) {
        TreeLinkNode node = new TreeLinkNode(val);
        this.left = node;
        return node;
    }

    public TreeLinkNode right(int val) {
        TreeLinkNode node = new TreeLinkNode(val);
        this.right = node;
        return node;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
