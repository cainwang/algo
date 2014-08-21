/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cainwang
 *
 */
public class ValidParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        boolean result = solution.isValid("()");
        System.out.println(result);
    }

    public boolean isValid(String s) {
        List<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.add(0, c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !match(stack.remove(0), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean match(char left, char right) {
        switch(left) {
        case '(':
            return right == ')';
        case '{':
            return right == '}';
        case '[':
            return right == ']';
        }

        return false;
    }
}
