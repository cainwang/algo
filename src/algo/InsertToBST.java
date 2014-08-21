/**
 *
 */
package algo;

import algo.leetcode.ListNode;
import algo.model.TreeNode;

/**
 * @author cainwang
 *
 */
public class InsertToBST {
    private TreeNode lowestImbalancedNode;

    private TreeNode lowestImbalancedNodeParent;

    /**
     * @param args
     */
    public static void main(String[] args) {
        InsertToBST solution = new InsertToBST();

        ListNode head = new ListNode(1);
        head.next(2).next(3).next(4).next(5).next(6);

        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        TreeNode root = new TreeNode(head.val);
        ListNode next = head.next;

        while (next != null) {
            insertIntoBST(root, next.val);

            TreeNode node = findLowestInbalanced(root);
            if (node != null) {
                TreeNode balancedNode = balanceBST(node, next.val);
                if (node == root) {
                    root = balancedNode;
                }
            }

            next = next.next;
        }

        return root;
    }

    private TreeNode findLowestInbalanced(TreeNode root) {
        checkDepth(root);
        return lowestImbalancedNode;
    }

    private int checkDepth(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        int leftDepth = 0;
        if (left != null) {
            leftDepth = checkDepth(left);
        }

        int rightDepth = 0;
        if (right != null) {
            rightDepth = checkDepth(right);
        }

        if (Math.abs(leftDepth - rightDepth) > 1 && lowestImbalancedNode == null) {
            lowestImbalancedNode = node;
        }
        if (lowestImbalancedNode != null && (lowestImbalancedNode == left || lowestImbalancedNode == right)) {
            lowestImbalancedNodeParent = node;
        }

        int childDepth = Math.max(leftDepth, rightDepth);

        return childDepth + 1;
    }

    private TreeNode insertIntoBST(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (value < node.val) {
            node.left = insertIntoBST(left, value);
        } else if (value > node.val) {
            node.right = insertIntoBST(right, value);
        }

        return node;
    }

    private TreeNode balanceBST(TreeNode root, int newValue) {
        int value = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode newRoot = root;

        if (newValue < value) {
            if (newValue < left.val) {
                root.left = left.right;
                left.right = root;

                newRoot = left;
            } else if (newValue > left.val) {
                TreeNode rightChild = left.right;

                left.right = rightChild.left;
                root.left = rightChild.right;

                rightChild.left = left;
                rightChild.right = root;

                newRoot = rightChild;
            }
        } else if (newValue > value) {
            if (newValue < right.val) {
                TreeNode leftChild = right.left;

                root.right = leftChild.left;
                left.left = leftChild.right;

                leftChild.left = root;
                leftChild.right = right;

                newRoot = leftChild;
            } else if (newValue > right.val) {
                root.right = right.left;
                right.left = root;

                newRoot = right;
            }
        }

        if (lowestImbalancedNodeParent != null) {
            if (lowestImbalancedNodeParent.left == root) {
                lowestImbalancedNodeParent.left = newRoot;
            } else {
                lowestImbalancedNodeParent.right = newRoot;
            }
        }

        lowestImbalancedNode = null;
        lowestImbalancedNodeParent = null;

        return newRoot;
    }
}
