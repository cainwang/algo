/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cainwang
 *
 */
public class ScrambleString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "vfldiodffghyq";
        String s2 = "vdgyhfqfdliof";

        ScrambleString solution = new ScrambleString();

        long time = System.currentTimeMillis();
        boolean result = solution.isScramble(s1, s2);
        System.out.println(System.currentTimeMillis() - time);

        System.out.println(result);
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        return check(s1, 0, s1.length(), s2, 0, s2.length());
    }

    private boolean check(String s1, int start1, int end1, String s2, int start2, int end2) {
        if (end1 - start1 == 1) {
            return s1.charAt(start1) == s2.charAt(start2);
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = start1; i < end1; i++) {
            Integer count = map.get(s1.charAt(i));

            if (count == null) {
                count = 0;
            }
            map.put(s1.charAt(i), ++count);
        }

        for (int i = start2; i < end2; i++) {
            Integer count = map.get(s2.charAt(i));

            if (count == null) {
                return false;
            } else {
                if (count == 0) {
                    return false;
                }
                map.put(s2.charAt(i), --count);
            }
        }

        for (int i = 1; i < end1 - start1; i++) {
            boolean noScrambleResult = check(s1, start1, start1 + i, s2, start2, start2 + i)
                    && check(s1, start1 + i, end1, s2, start2 + i, end2);
            boolean scrambleResult = check(s1, start1, start1 + i, s2, end2 - i, end2)
                    && check(s1, start1 + i, end1, s2, start2, end2 - i);

            if (noScrambleResult || scrambleResult) {
                return true;
            }
        }

        return false;
    }
}
