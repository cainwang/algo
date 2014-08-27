/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class PartitionList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode input = new ListNode(1);

        PartitionList solution = new PartitionList();
        ListNode head = solution.partition(input, 0);

        System.out.println(head.toString());
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = null, smallerTail = null, biggerHead = null, biggerTail = null;

        while (head != null) {
            int val = head.val;

            if (val < x) {
                if (smallerHead == null) {
                    smallerHead = head;
                    smallerTail = head;
                } else {
                    smallerTail.next = head;
                    smallerTail = head;
                }
            } else {
                if (biggerHead == null) {
                    biggerHead = head;
                    biggerTail = head;
                } else {
                    biggerTail.next = head;
                    biggerTail = head;
                }
            }

            head = head.next;
        }

        if (biggerTail != null) {
            biggerTail.next = null;
        }
        if (smallerTail != null) {
            smallerTail.next = biggerHead;
        }

        return smallerHead == null ? biggerHead : smallerHead;
    }
}
