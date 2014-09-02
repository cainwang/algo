/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class ReverseNodesInKGroup {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(2).next(3);

        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        ListNode result = solution.reverseKGroup(head, 1);

        System.out.println(result);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode reverseHead = null, reverseTail = null;
        ListNode segHead = null, segTail = null;

        int count = 1;

        if (!canReach(head, k)) {
            return head;
        }

        while (head != null) {
            ListNode next = head.next;

            if (count == 1) {
                segHead = head;
                segTail = head;

                segTail.next = null;
            } else if (count <= k) {
                head.next = segHead;
                segHead = head;
            }
            if (count == k) {
                if (reverseHead == null) {
                    reverseHead = segHead;
                    reverseTail = segTail;
                } else {
                    reverseTail.next = segHead;
                    reverseTail = segTail;
                }

                if (next != null && !canReach(next, k)) {
                    reverseTail.next = next;
                    break;
                }

                count = 1;
            } else {
                count ++;
            }

            head = next;
        }

        return reverseHead;
    }

    private boolean canReach(ListNode head, int target) {
        int count = 0;

        while (head != null) {
            count ++;

            if (count == target) {
                return true;
            }

            head = head.next;
        }

        return false;
    }
}
