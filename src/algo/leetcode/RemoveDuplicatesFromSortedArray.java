/**
 *
 */
package algo.leetcode;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 3, 4, 7, 7, 7, 7, 9};

        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        System.out.println(solution.removeDuplicates(source));
        System.out.println(Arrays.toString(source));
    }

    public int removeDuplicates(int[] a) {
        if (a == null) {
            return 0;
        }
        if (a.length == 0) {
            return 0;
        }

        int len = a.length;
        int start = 0;

        for (int i = 1; i < len; i ++) {
            int item = a[i];

            if (item == a[start]) {
                continue;
            } else {
                a[++ start] = item;
            }
        }

        return start + 1;
    }
}
