package algo;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(2).next(3).next(4);

        SwapNodesInPairs solution = new SwapNodesInPairs();
        head = solution.swapPairs(head);

        System.out.println(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head != null) {
            return doSwap(null, head);
        };

        return head;
    }

    public ListNode doSwap(ListNode previous, ListNode current) {
        ListNode next = current.next;

        if (next != null) {
            ListNode nextStart = next.next;

            if (previous != null) {
                previous.next = next;
            }
            next.next = current;

            current.next = nextStart;

            if (nextStart != null) {
                doSwap(current, nextStart);
            }

            return next;
        }

        return current;
    }
}
