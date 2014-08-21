/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthFromEnd(head, 1);

        if (head != null) {
            System.out.println(head.toString());
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode front = head;
        ListNode back = head;
        ListNode previousBack = null;

        int distance = 0;

        while (front != null) {
            front = front.next;
            distance ++;

            if (distance > n) {
                previousBack = back;
                back = back.next;
            }
        }

        if (previousBack == null) {
            return back.next;
        } else {
            previousBack.next = back.next;
        }

        return head;
    }
}
