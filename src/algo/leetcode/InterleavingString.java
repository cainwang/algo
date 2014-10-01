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
public class InterleavingString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";

        InterleavingString solution = new InterleavingString();
        boolean result = solution.isInterleave(s1, s2, s3);

        System.out.println(result);
    }

    private Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        return check(s1, 0, s2, 0, s3, 0);
    }

    private boolean check(String s1, int start1, String s2, int start2, String s3, int start3) {
        String key = start1 + "-" + start2 + "-" + start3;

        if (cache.get(key) != null) {
            return cache.get(key);
        }

        boolean result = false;

        if (start3 == s3.length()) {
            result = start1 == s1.length() && start2 == s2.length();
        } else {
            char c = s3.charAt(start3);
            char c1 = ' ';
            char c2 = ' ';

            if (start1 < s1.length()) {
                c1 = s1.charAt(start1);
            }
            if (start2 < s2.length()) {
                c2 = s2.charAt(start2);
            }

            if (c == c1) {
                if (check(s1, start1 + 1, s2, start2, s3, start3 + 1)) {
                    result = true;
                }
            }
            if (c == c2 && !result) {
                if (check(s1, start1, s2, start2 + 1, s3, start3 + 1)) {
                    result = true;
                }
            }

            cache.put(key, result);
        }

        return result;
    }
}
