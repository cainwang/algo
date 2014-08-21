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
public class GenerateParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        traverse(result, "", n, n, n);
        return result;
    }

    public void traverse(List<String> result, String head, int n, int left, int right) {
        if (right == 0) {
            result.add(head);
        } else {
            if (right > left) {
                traverse(result, head + ")", n, left, right - 1);
            }
            if (left > 0) {
                traverse(result, head + "(", n, left - 1, right);
            }
        }
    }
}
