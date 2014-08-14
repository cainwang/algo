/**
 *
 */
package algo;

import java.util.Arrays;

/**
 * @author cainwang
 *
 */
public class RemoveDuplicatesFromSortedArray2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray2 solution = new RemoveDuplicatesFromSortedArray2();
        int[] a = new int[] { 1, 1 };
        int len = solution.removeDuplicates(a);

        System.out.println(len);
        System.out.println(Arrays.toString(a));
    }

    public int removeDuplicates(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }

        int lastChecked = 0, repeat = 0;

        for (int i = 1; i < a.length; i++) {
            int value = a[i];

            if (value == a[lastChecked]) {
                if (repeat < 1) {
                    a[++lastChecked] = value;
                    repeat++;
                }
            } else {
                a[++ lastChecked] = value;
                repeat = 0;
            }
        }

        return lastChecked + 1;
    }
}
