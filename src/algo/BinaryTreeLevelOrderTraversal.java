/**
 *
 */
package algo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left(2);
        root.right(3);

        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> row = new LinkedList<>();
            List<TreeNode> children = new LinkedList<>();

            for (TreeNode node : nodes) {
                row.add(node.val);

                if (node.left != null) {
                    children.add(node.left);
                }

                if (node.right != null) {
                    children.add(node.right);
                }

            }

            result.add(row);
            nodes = children;
        }

        return result;
    }
}
