/**
 *
 */
package algo;

import java.util.Arrays;

/**
 * @author cainwang
 *
 */
public class QuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] input = {3, 2, 1, 4};

        QuickSort solution = new QuickSort();
        solution.qsort(input);

        System.out.println(Arrays.toString(input));
    }

    public void qsort(int[] array) {
        doSort(array, 0, array.length);
    }

    private void doSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        int pivotValue = array[mid];

        array[mid] = array[end - 1];
        array[end - 1] = pivotValue;

        int pivot = start;

        for (int i = start; i < end - 1; i ++) {
            if (array[i] < pivotValue) {
                int swap = array[i];
                array[i] = array[pivot];
                array[pivot] = swap;

                pivot ++;
            }
        }

        array[end - 1] = array[pivot];
        array[pivot] = pivotValue;

        doSort(array, start, pivot);
        doSort(array, pivot, end);
    }
}
