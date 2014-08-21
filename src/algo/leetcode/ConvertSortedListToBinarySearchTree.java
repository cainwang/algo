/**
 *
 */
package algo.leetcode;

import algo.model.TreeNode;

/**
 * @author Cain
 *
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { -99, -92, -73, -47, -2, 7, 12, 24, 25, 36, 75, 89 };

        ListNode head = new ListNode(inputs[0]);
        ListNode node = head;

        for (int i = 1; i < inputs.length; i++) {
            int input = inputs[i];

            node.next = new ListNode(input);
            node = node.next;
        }

        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        TreeNode result = solution.sortedListToBST(head);
        System.out.println(result);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        TreeNode root = new TreeNode(head.val);
        TreeNode treeNode = root;

        int len = 1;

        while (head.next != null) {
            treeNode.right = new TreeNode(head.next.val);
            treeNode = treeNode.right;

            head = head.next;
            len++;
        }

        return reverseHalf(root, len, false);
    }

    private TreeNode reverseHalf(TreeNode root, int len, boolean leftPath) {
        if (len <= 2) {
            return root;
        }

        int halfLen = len / 2;
        int count = 0;

        TreeNode node = root;
        int leftLen, rightLen;

        while (count < halfLen) {
            if (leftPath) {
                root = root.left;

                root.right = node;
                node.left = null;

                node = root;
            } else {
                root = root.right;

                root.left = node;
                node.right = null;

                node = root;
            }

            count++;
        }

        if (leftPath) {
            rightLen = count;
            leftLen = len - count - 1;
        } else {
            leftLen = count;
            rightLen = len - count - 1;
        }

        root.left = reverseHalf(root.left, leftLen, true);
        root.right = reverseHalf(root.right, rightLen, false);

        return root;
    }
}
