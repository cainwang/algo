package algo;

public class SortedArrayToBST {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return new TreeNode(0);
        }

        return createBST(num, 0, num.length);
    }

    private TreeNode createBST(int[] num, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            TreeNode node = new TreeNode(num[mid]);

            node.left = createBST(num, start, mid);
            node.right = createBST(num, mid + 1, end);

            return node;
        }

        return null;
    }
}
