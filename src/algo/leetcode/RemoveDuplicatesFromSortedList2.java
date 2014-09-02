/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class RemoveDuplicatesFromSortedList2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(2);

        RemoveDuplicatesFromSortedList2 solution = new RemoveDuplicatesFromSortedList2();
        head = solution.deleteDuplicates(head);

        System.out.println(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode uniqueTail = null;
        ListNode uniqueHead = null;
        ListNode tentativeNode = null;

        boolean duplicate = false;

        while (head != null) {
            if (tentativeNode == null) {
                tentativeNode = head;
            } else {
                if (head.val == tentativeNode.val) {
                    duplicate = true;
                } else {
                    if (duplicate) {
                        tentativeNode = head;
                        duplicate = false;
                    } else {
                        if (uniqueHead == null) {
                            uniqueHead = tentativeNode;
                            uniqueTail = tentativeNode;
                        } else {
                            uniqueTail.next = tentativeNode;
                            uniqueTail = tentativeNode;
                        }
                        tentativeNode = head;
                    }
                }
            }

            head = head.next;
        }

        if (tentativeNode != null && !duplicate) {
            if (uniqueTail == null) {
                uniqueHead = tentativeNode;
                uniqueTail = tentativeNode;
            } else {
                uniqueTail.next = tentativeNode;
                uniqueTail = tentativeNode;
            }
        }

        if (uniqueTail != null) {
            uniqueTail.next = null;
        }

        return uniqueHead;
    }
}
