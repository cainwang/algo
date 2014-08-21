/**
 *
 */
package algo.leetcode;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class SortColors {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] colors = new int[] {1, 2, 0};
        solution.sortColors(colors);

        System.out.println(Arrays.toString(colors));
    }

    public void sortColors(int[] a) {
        for (int i = 1; i < a.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (a[j] < a[j - 1]) {
                    int value = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = value;
                }
            }
        }
    }
}
