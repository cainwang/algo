/**
 *
 */
package algo.leetcode;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class MergeSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 0, 0, 0, 0};
        int[] b = {-1, 3, 4, 5};

        MergeSortedArray solution = new MergeSortedArray();
        solution.merge(a, a.length - b.length, b, b.length);

        System.out.println(Arrays.toString(a));
    }

    public void merge(int a[], int m, int b[], int n) {
        int aIndex = m - 1, bIndex = n - 1;

        for (int i = m + n - 1; i >= 0; i --) {
            Integer aItem = aIndex >= 0 ? a[aIndex] : null;
            Integer bItem = bIndex >= 0 ? b[bIndex] : null;
            boolean fromB = false;

            if (aIndex < 0) {
                fromB = true;
            } else if (bIndex < 0) {
                fromB = false;
            } else if (a[aIndex] < b[bIndex]) {
                fromB = true;
            } else {
                fromB = false;
            }

            if (fromB) {
                a[i] = bItem;
                bIndex --;
            } else {
                a[i] = aItem;
                aIndex --;
            }
        }
    }
}
