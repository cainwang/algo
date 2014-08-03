/**
 *
 */
package algo;

/**
 * @author Cain
 *
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
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
