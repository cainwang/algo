/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class ReverseLinkedList2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(2).next(3).next(4);

        ReverseLinkedList2 solution = new ReverseLinkedList2();
        head = solution.reverseBetween(head, 2, 4);

        System.out.println(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m <= 0 || n <= 0 || m >= n) {
            return head;
        }

        int count = 1;
        ListNode previous = null, firstTail = null, reverseTail = null, reverseHead = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;

            if (count == m) {
                firstTail = previous;
                reverseTail = node;
                reverseHead = node;
            } else if (count > m) {
                if (count <= n) {
                    node.next = reverseHead;
                    reverseHead = node;

                    if (count == n) {
                        if (firstTail != null) {
                            firstTail.next = reverseHead;
                        }
                        reverseTail.next = next;

                        break;
                    }
                }
            }

            previous = node;
            node = next;
            count++;
        }

        if (m == 1) {
            head = reverseHead;
        }

        return head;
    }
}
