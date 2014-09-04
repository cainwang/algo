/**
 *
 */
package algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class CombinationSum2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] input = { 1, 1 };

        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> results = solution.combinationSum2(input, 1);

        System.out.println(results);
    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new LinkedList<>();

        if (num == null || num.length == 0) {
            return results;
        }

        Arrays.sort(num);

        List<Integer> remains = new LinkedList<>();
        for (int n : num) {
            remains.add(n);
        }

        find(results, new LinkedList<Integer>(), remains, 0, target);

        return results;
    }

    private void find(List<List<Integer>> results, List<Integer> result, List<Integer> remains, int sum, int target) {
        if (sum == target) {
            results.add(result);
        } else if (sum < target && !remains.isEmpty()) {
            Map<Integer, Boolean> usedMap = new HashMap<>();

            for (int i = 0; i < remains.size(); i++) {
                int remain = remains.get(i);

                if (usedMap.get(remain) != null) {
                    continue;
                }
                usedMap.put(remain, true);

                List<Integer> newResult = new LinkedList<>(result);
                newResult.add(remain);

                List<Integer> newRemains = remains.subList(i + 1, remains.size());

                find(results, newResult, newRemains, sum + remain, target);
            }
        }
    }
}
