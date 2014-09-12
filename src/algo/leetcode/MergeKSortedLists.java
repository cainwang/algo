/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class MergeKSortedLists {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<ListNode> inputs = new LinkedList<>();
        inputs.add(null);
        inputs.add(new ListNode(1));

        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode result = solution.mergeKLists(inputs);

        System.out.println(result);
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }

        ListNode result = null;
        ListNode resultEnd = null;

        for (int i = lists.size() - 1; i >= 0; i --) {
            if (lists.get(i) == null) {
                lists.remove(i);
            }
        }

        while (!lists.isEmpty()) {
            ListNode min = null;
            int minIndex = -1;

            for (int i = lists.size() - 1; i >= 0; i --) {
                ListNode node = lists.get(i);

                if (min == null || node.val < min.val) {
                    min = node;
                    minIndex = i;
                }
            }

            ListNode next = min.next;
            lists.remove(minIndex);
            if (next != null) {
                lists.add(minIndex, next);
            }

            min.next = null;
            if (result == null) {
                result = min;
                resultEnd = min;
            } else {
                resultEnd.next = min;
                resultEnd = min;
            }
        }

        return result;
    }
}
