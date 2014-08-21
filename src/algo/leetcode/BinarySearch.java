/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class BinarySearch {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int target = 4;

        int start = 0, end = array.length, index = -1;

        while (start < end) {
            int mid = (start + end) >>> 1;
            int midValue = array[mid];

            if (midValue < target) {
                start = mid + 1;
            } else if (midValue > target) {
                end = mid;
            } else {
                index = mid;
                break;
            }
        }

        System.out.println(index);
    }
}
