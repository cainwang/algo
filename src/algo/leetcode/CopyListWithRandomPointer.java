/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class CopyListWithRandomPointer {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;

        while (node != null) {
            RandomListNode next = node.next;

            node.next = new RandomListNode(node.label);
            node.next.next = next;

            node = next;
        }

        node = head;
        while (node != null) {
            RandomListNode newNode = node.next;

            RandomListNode random = node.random;
            if (random != null) {
                newNode.random = random.next;
            }

            node = newNode.next;
        }

        node = head;
        RandomListNode newHead = null;
        RandomListNode newTail = null;
        while (node != null) {
            RandomListNode newNode = node.next;

            if (newHead == null) {
                newHead = newNode;
                newTail = newHead;
            } else {
                newTail.next = newNode;
                newTail = newNode;
            }

            node.next = newNode.next;
            node = newNode.next;
        }

        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
