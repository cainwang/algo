/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class InsertionSortList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next(2).next(1).next(3);

        InsertionSortList solution = new InsertionSortList();
        head = solution.insertionSortList(head);

        System.out.println(head.toString());
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode sortedHead = head;
        ListNode node = head.next;

        sortedHead.next = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;

            sortedHead = insert(sortedHead, node);
            node = next;
        }

        return sortedHead;
    }

    private ListNode insert(ListNode head, ListNode target) {
        ListNode previous = null;
        ListNode node = head;

        while (node != null) {
            if (target.val < node.val) {
                if (previous == null) {
                    target.next = node;
                    return target;
                } else {
                    previous.next = target;
                    target.next = node;

                    return head;
                }
            }

            previous = node;
            node = node.next;
        }

        previous.next = target;

        return head;
    }
}
