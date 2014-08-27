/**
 *
 */
package algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class CombinationSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { 2, 3, 6, 7 };
        int target = 7;

        CombinationSum solution = new CombinationSum();
        List<List<Integer>> results = solution.combinationSum(inputs, target);
        System.out.println(results);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> results = new LinkedList<>();
        findSum(results, new LinkedList<Integer>(), candidates, 0, 0, target);

        return results;
    }

    private void findSum(List<List<Integer>> results, List<Integer> combination, int[] candidates, int start, int sum,
            int target) {
        if (sum == target) {
            results.add(combination);
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            List<Integer> newResult = new LinkedList<>(combination);
            newResult.add(candidates[i]);

            findSum(results, newResult, candidates, i, sum + candidates[i], target);
        }
    }
}
