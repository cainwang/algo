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
public class EditDistance {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        //word1 = "plasma";
        //word2 = "altruism";

        EditDistance solution = new EditDistance();
        int step = solution.minDistance(word1, word2);

        System.out.println(step);
    }

    private Map<Integer, Integer> cache = new HashMap<>();

    public int minDistance(String word1, String word2) {
        if (word1 == null) {
            word1 = "";
        }
        if (word2 == null) {
            word2 = "";
        }

        return step(word1, word2, 0, 0);
    }

    private int step(String word1, String word2, int start1, int start2) {
        if (start1 == word1.length()) {
            return word2.length() - start2;
        }
        if (start2 == word2.length()) {
            return word1.length() - start1;
        }

        int loc = word2.length() * start1 + start2;
        if (cache.get(loc) != null) {
            return cache.get(loc);
        }
        if (loc == 4) {
            System.out.println();
        }

        char c1 = word1.charAt(start1);
        char c2 = word2.charAt(start2);

        int steps;
        if (c1 == c2) {
            steps = step(word1, word2, start1 + 1, start2 + 1);
        } else {
            int replaceStep = step(word1, word2, start1 + 1, start2 + 1) + 1;
            int insertStep = step(word1, word2, start1, start2 + 1) + 1;
            int deleteStep = step(word1, word2, start1 + 1, start2) + 1;

            steps = Math.min(deleteStep, Math.min(replaceStep, insertStep));
        }

        cache.put(loc, steps);

        return steps;
    }
}
