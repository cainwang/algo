/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class ThreeSumCloest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = { -1, -5, -3, -4, 2, -2 };

        ThreeSumCloest solution = new ThreeSumCloest();
        int sum = solution.threeSumClosest(inputs, 0);
        System.out.println(sum);
    }

    public int threeSumClosest(int[] array, int target) {
        if (array == null || array.length < 3) {
            return -1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int swap = array[j];
                array[j] = array[j - 1];
                array[j - 1] = swap;
            }
        }

        int start = 0, mid = array.length - 2, end = array.length - 1;
        int closestSum = target;

        while (start < mid && start < end) {
            int sum = array[start] + array[mid] + array[end];
            if (sum == target) {
                closestSum = sum;
                break;
            }

            if (closestSum == target || Math.abs(closestSum - target) > Math.abs(sum - target)) {
                closestSum = sum;
            }

            if (mid > start + 1) {
                if (sum > target) {
                    mid--;
                } else {
                    start++;
                }
            } else {
                end--;
                mid = end - 1;
                start = 0;
            }
        }

        return closestSum;
    }
}
