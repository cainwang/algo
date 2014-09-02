/**
 *
 */
package algo.leetcode;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class NextPermutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { 1, 2 };

        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(inputs);

        System.out.println(Arrays.toString(inputs));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = -1, end = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = nums.length - 1; i > start; i--) {
            if (nums[i] > nums[start]) {
                end = i;
                break;
            }
        }

        int swap = nums[start];
        nums[start] = nums[end];
        nums[end] = swap;

        start++;
        end = nums.length - 1;

        while (start < end) {
            swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;

            start++;
            end--;
        }
    }
}
