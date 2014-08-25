/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cainwang
 *
 */
public class Subsets2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { 4, 4, 4, 1, 4 };

        Subsets2 solution = new Subsets2();
        List<List<Integer>> results = solution.subsetsWithDup(inputs);

        System.out.println(results);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        results.add(new LinkedList<Integer>());

        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j --) {
                int swap = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = swap;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            findSubset(nums, 0, i, new LinkedList<Integer>(), results);
        }

        return results;
    }

    private void findSubset(int[] nums, int start, int remain, List<Integer> result, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(result);
            return;
        }

        Map<Integer, Boolean> usedMap = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            List<Integer> newResult = new LinkedList<>(result);
            int num = nums[i];

            if (usedMap.get(nums[i]) != null) {
                continue;
            }
            usedMap.put(num, true);
            newResult.add(num);

            findSubset(nums, i + 1, remain - 1, newResult, results);
        }
    }

}
