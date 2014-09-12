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
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int result = solution.lengthOfLongestSubstring("abca");

        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLen = 0;
        int len = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);

            if (map.get(c) != null) {
                int dupIndex = map.get(c);
                if (len > maxLen) {
                    maxLen = len;
                }
                len -= dupIndex - start + 1;

                for (int j = start; j <= dupIndex; j ++) {
                    map.remove(s.charAt(j));
                }
                start = dupIndex + 1;
            }

            map.put(c, i);
            len ++;
        }
        if (len > maxLen) {
            maxLen = len;
        }

        return maxLen;
    }
}
