/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode next(int value) {
        next = new ListNode(value);
        return next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        ListNode head = this;
        while (head != null) {
            builder.append(head.val).append(' ');
            head = head.next;
        }

        return builder.toString();
    }
}
