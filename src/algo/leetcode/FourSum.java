/**
 *
 */
package algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cainwang
 *
 */
public class FourSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { 361, 408, 421, 492, 361, 408, 421, 492 };
        int target = 1682;

        FourSum solution = new FourSum();
        List<List<Integer>> results = solution.fourSum(inputs, target);

        System.out.println(results);
    }

    private List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return results;
        }

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 4; i++) {
            int startNum = nums[i];
            findThreeSum(nums, i + 1, nums.length - 1, target - startNum, startNum, results);
        }

        return results;
    }

    private void findThreeSum(int[] nums, int startIndex, int endIndex, int target, int startNum,
            List<List<Integer>> results) {
        if (startIndex >= endIndex) {
            return;
        }

        int start = startIndex, end = endIndex;

        while (start < end - 1) {
            int mid = end - 1;

            while (start < mid) {
                int sum = nums[start] + nums[mid] + nums[end];

                if (sum == target) {
                    List<Integer> result = new LinkedList<>();
                    result.add(startNum);
                    result.add(nums[start]);
                    result.add(nums[mid]);
                    result.add(nums[end]);

                    if (!contains(results, result)) {
                        results.add(result);
                    }

                    start++;
                    mid--;
                } else if (sum < target) {
                    start++;
                } else {
                    mid--;
                }
            }

            start = startIndex;
            end--;
        }
    }

    private boolean contains(List<List<Integer>> results, List<Integer> target) {
        for (List<Integer> result : results) {
            if (result.size() == target.size()) {
                for (int i = 0; i < result.size(); i++) {
                    if (!result.get(i).equals(target.get(i))) {
                        break;
                    }

                    if (i == result.size() - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
