/**
 *
 */
package algo;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class Sum2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 5, 6 };

        Sum2 solution = new Sum2();
        int[] results = solution.findSum(array, 3);

        System.out.println(Arrays.toString(results));
    }

    public int[] findSum(int[] array, int target) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1 && array[j] < array[j - 1]; j--) {
                int swap = array[j];
                array[j] = array[j - 1];
                array[j - 1] = swap;
            }
        }

        int start = 0, end = array.length - 1;
        int closestSum = 0;
        int closestStart = -1, closestEnd = -1;

        while (start < end) {
            int sum = array[start] + array[end];

            if (Math.abs(sum - target) < Math.abs(closestSum - sum)) {
                closestSum = sum;
                closestStart = start;
                closestEnd = end;
            }

            if (sum == target) {
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] { array[closestStart], array[closestEnd] };
    }
}
