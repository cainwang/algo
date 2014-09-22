/**
 *
 */
package algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Cain
 *
 */
public class WordBreak {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> source = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaa");
        Set<String> set = new HashSet<>(source);

        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        WordBreak solution = new WordBreak();
        boolean result = solution.wordBreak(input, set);

        System.out.println(result);
    }

    Map<Integer, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, Set<String> dict) {
        Map<String, Boolean> map = new HashMap<>();

        for (String word : dict) {
            map.put(word, true);
        }

        return doBreak(s, 0, map);
    }

    private boolean doBreak(String s, int start, Map<String, Boolean> map) {
        if (cache.get(start) != null) {
            return false;
        }

        if (start == 150) {
            System.out.println();
        }
        System.out.println(start);

        for (int i = start + 1; i <= s.length(); i++) {
            String sequence = s.substring(start, i);
            if (map.get(sequence) != null) {
                if (i == s.length()) {
                    return true;
                } else {
                    if (doBreak(s, i, map)) {
                        return true;
                    }
                }
            }
        }

        cache.put(start, false);

        return false;
    }
}
