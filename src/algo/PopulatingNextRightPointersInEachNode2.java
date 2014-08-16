/**
 *
 */
package algo;

import algo.model.TreeLinkNode;


/**
 * @author cainwang
 *
 */
public class PopulatingNextRightPointersInEachNode2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = root.left(2);
        left.left(4).left(7);
        left.right(5);

        TreeLinkNode right = root.right(3);
        right.right(6).right(8);

        PopulatingNextRightPointersInEachNode2 solution = new PopulatingNextRightPointersInEachNode2();
        solution.connect(root);
        System.out.println(root);
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode nextLevelHead = root;

        while (nextLevelHead != null) {
            // For each level.
            TreeLinkNode head = nextLevelHead;
            nextLevelHead = null;
            TreeLinkNode nextLevelTail = null;

            // For each node.
            while (head != null) {
                TreeLinkNode left = head.left;
                TreeLinkNode right = head.right;

                if (left != null) {
                    if (nextLevelHead == null) {
                        nextLevelHead = left;
                        nextLevelTail = left;
                    } else {
                        nextLevelTail.next = left;
                        nextLevelTail = left;
                    }
                }
                if (right != null) {
                    if (nextLevelHead == null) {
                        nextLevelHead = right;
                        nextLevelTail = right;
                    } else {
                        nextLevelTail.next = right;
                        nextLevelTail = right;
                    }
                }

                head = head.next;
            }
        }
    }
}
