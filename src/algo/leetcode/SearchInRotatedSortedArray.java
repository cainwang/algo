/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class SearchInRotatedSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int result = solution.search(new int[] {1, 3},  0);
        System.out.println(result);
    }

    public int search(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return a[0] == target ? 0 : -1;
        }

        int pivot = -1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                pivot = i + 1;
            }
        }

        int start = 0, end = a.length;
        if (pivot != -1) {
            if (target < a[0]) {
                start = pivot;
                end = a.length;
            } else {
                start = 0;
                end = pivot;
            }
        }

        while (start < end) {
            int mid = (start + end) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }
}
