/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class RotateList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(2);

        RotateList solution = new RotateList();
        ListNode result = solution.rotateRight(head, 2);

        System.out.println(result);
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }

        int length = 0;
        int steps = 0;
        ListNode first = head;
        ListNode second = head;

        while (first != null) {
            first = first.next;
            length ++;
        }

        first = head;
        n = n % length;

        if (n == 0) {
            return head;
        }

        while (first.next != null) {
            first = first.next;
            if (steps >= n) {
                second = second.next;
            }

            steps ++;
        }

        if (steps >= n) {
            ListNode newHead = second.next;
            second.next = null;

            first.next = head;
            head = newHead;
        }

        return head;
    }
}
