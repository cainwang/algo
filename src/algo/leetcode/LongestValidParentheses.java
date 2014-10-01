/**
 *
 */
package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class LongestValidParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String input = "()(()";
        LongestValidParentheses solution = new LongestValidParentheses();
        int result = solution.longestValidParentheses(input);

        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        List<int[]> spans = new LinkedList<>();

        Deque<Integer> deque = new LinkedList<>();
        int maxSpan = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                deque.add(i);
            } else if (c == ')') {
                Integer start = deque.pollLast();

                if (start != null) {
                    insert(spans, new int[] { start, i });
                }
            }
        }

        for (int[] span : spans) {
            int len = span[1] - span[0];
            if (len > maxSpan) {
                maxSpan = len + 1;
            }
        }

        return maxSpan;
    }

    private void insert(List<int[]> spans, int[] target) {
        int insertIndex = -1;

        if (spans.isEmpty()) {
            spans.add(target);
            return;
        }

        for (int i = 0; i < spans.size(); i++) {
            int[] span = spans.get(i);

            if (!(target[1] < span[0] - 1 || target[0] > span[1] + 1)) {
                span[0] = Math.min(span[0], target[0]);
                span[1] = Math.max(span[1], target[1]);

                target = span;
                if (insertIndex != -1) {
                    spans.remove(insertIndex);
                }

                insertIndex = i;
            }
        }

        if (insertIndex == -1) {
            int[] firstSpan = spans.get(0);

            if (target[0] < firstSpan[0]) {
                spans.add(0, target);
            } else {
                spans.add(target);
            }
        }
    }
}
