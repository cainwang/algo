/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class Permutations2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] input = {1};

        Permutations2 solution = new Permutations2();
        List<List<Integer>> results = solution.permuteUnique(input);
        System.out.println(results);
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> results = new LinkedList<>();

        if (num == null || num.length == 0) {
            return results;
        }

        List<Integer> remains = new LinkedList<>();
        for (int i : num) {
            remains.add(i);
        }

        permute(results, new LinkedList<Integer>(), remains);

        return results;
    }

    private void permute(List<List<Integer>> results, List<Integer> result, List<Integer> remains) {
        if (remains.size() == 0) {
            results.add(result);
            return;
        }

        Map<Integer, Boolean> usedMap = new HashMap<>();

        for (int i = 0; i < remains.size(); i++) {
            int val = remains.get(i);

            if (usedMap.get(val) != null) {
                continue;
            }
            usedMap.put(val, true);

            List<Integer> newRemains = new LinkedList<>(remains);
            newRemains.remove(i);

            List<Integer> newResult = new LinkedList<>(result);
            newResult.add(val);

            permute(results, newResult, newRemains);
        }
    }
}
