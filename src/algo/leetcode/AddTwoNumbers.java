/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class AddTwoNumbers {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        //l1.next(1);

        ListNode l2 = new ListNode(5);
        //l2.next(2);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultHead = null;

        boolean carryOne = false;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2;

            if (carryOne) {
                sum ++;
                carryOne = false;
            }

            if (sum >= 10) {
                carryOne = true;
                sum -= 10;
            }

            if (resultHead == null) {
                resultHead = new ListNode(sum);
                result = resultHead;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carryOne) {
            result.next = new ListNode(1);
        }

        return resultHead;
    }
}
