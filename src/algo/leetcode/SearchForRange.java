/**
 *
 */
package algo.leetcode;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class SearchForRange {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2, 3 };

        SearchForRange solution = new SearchForRange();
        int[] range = solution.searchRange(a, 2);

        System.out.println(Arrays.toString(range));
    }

    public int[] searchRange(int[] a, int target) {
        int rangeStart = -1, rangeEnd = -1;

        if (a != null && a.length > 0) {
            int start = 0, end = a.length;
            int targetIndex = -1;

            while (start < end) {
                int mid = (start + end) / 2;
                int midValue = a[mid];

                if (midValue == target) {
                    targetIndex = mid;
                    break;
                } else if (midValue < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (targetIndex != -1) {
                int i = targetIndex;
                while (i >= 0 && a[i] == target) {
                    i--;
                }
                rangeStart = i + 1;

                i = targetIndex;
                while (i < a.length && a[i] == target) {
                    i++;
                }
                rangeEnd = i - 1;
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }
}
