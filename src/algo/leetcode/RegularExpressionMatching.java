/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class RegularExpressionMatching {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String source = "a";
        String expr = "ab*";

        RegularExpressionMatching solution = new RegularExpressionMatching();
        boolean result = solution.isMatch(source, expr);

        System.out.println(result);
    }

    private Map<Integer, Boolean> cache = new HashMap<>();

    public boolean isMatch(String source, String expr) {
        return doMatch(source, 0, expr, 0);
    }

    private boolean doMatch(String source, int sourceStart, String expr, int exprStart) {
        for (int i = exprStart; i < expr.length(); i ++) {
            char c = expr.charAt(i);
            char next = 0;
            if (i < expr.length() - 1) {
                next = expr.charAt(i + 1);
            }

            if (next == '*') {
                int j = sourceStart;
                for (; j < source.length(); j ++) {
                    char sourceChar = source.charAt(j);

                    if (c != '.' && sourceChar != c) {
                        break;
                    }

                    int key = i * source.length() + j;
                    if (cache.get(key) != null) {
                        return cache.get(key);
                    }

                    boolean result = doMatch(source, j, expr, i + 2);
                    cache.put(key, result);

                    if (result) {
                        return result;
                    }
                }
                sourceStart = j;

                i ++;
            } else {
                if (sourceStart >= source.length()) {
                    return false;
                }
                if (c != '.' && c != source.charAt(sourceStart)) {
                    return false;
                }

                sourceStart ++;
            }
        }

        return sourceStart == source.length();
    }
}
