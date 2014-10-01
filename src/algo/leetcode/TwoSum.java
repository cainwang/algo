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
public class TwoSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { 5, 75, 25 };
        int target = 100;
        TwoSum solution = new TwoSum();

        int[] results = solution.twoSum(inputs, target);
        System.out.println(Arrays.toString(results));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);

        Arrays.sort(sorted);

        int start = 0;
        int end = sorted.length - 1;

        while (start < end) {
            int sum = sorted[start] + sorted[end];

            if (sum == target) {
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> list = new LinkedList<>();
        list.add(sorted[start]);
        list.add(sorted[end]);

        List<Integer> results = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            for (int j = list.size() - 1; j >= 0; j--) {
                if (num == list.get(j)) {
                    list.remove(j);
                    results.add(i + 1);
                    break;
                }
            }
        }

        int[] arrays = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            arrays[i] = results.get(i);
        }

        return arrays;
    }
}
