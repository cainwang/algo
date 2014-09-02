/**
 *
 */
package algo.leetcode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class DistinctSubsequences {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("data/input.txt");
        byte[] content = Files.readAllBytes(path);

        String s = new String(content);
        String t = "rwmimatmhydhbujebqehjprarwfkoebcxxqfktayaaeheys";

        //s = "ssttest22";
        //t = "test";

        DistinctSubsequences solution = new DistinctSubsequences();
        int result = solution.numDistinct(s, t);

        System.out.println(result);
    }

    private Map<Integer, Integer> cache = new HashMap<>();

    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        if (s.length() == t.length() && s.equals(t)) {
            return 1;
        }

        int result = findSubsequence(s, t, 0, t.length());

        return result;
    }

    private int findSubsequence(String s, String t, int start, int remains) {
        if (remains == 0) {
            return 1;
        }

        int key = s.length() * start + remains;
        if (cache.get(key) != null) {
            return cache.get(key);
        }

        int result = 0;
        char targetChar = t.charAt(t.length() - remains);

        for (int i = start; i < s.length() - remains + 1; i++) {
            char c = s.charAt(i);

            if (c == targetChar) {
                result += findSubsequence(s, t, i + 1, remains - 1);
            }
        }

        cache.put(key, result);

        return result;
    }
}
