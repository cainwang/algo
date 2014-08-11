/**
 *
 */
package algo;


/**
 * @author Cain
 *
 */
public class Search2DMatrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int size = 10;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < size; j++) {
                row[j] = i * size + j;
            }
        }

        int[][] test = {{1}, {3}, {5}};

        Search2DMatrix solution = new Search2DMatrix();
        System.out.println(solution.searchMatrix(test, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int start = 0, end = matrix.length;

        while (start < end) {
            int mid = (start + end) >>> 1;

            int midVal = matrix[mid][0];

            if (midVal < target) {
                if (end - start > 1) {
                    start = mid;
                } else {
                    break;
                }
            } else if (midVal > target) {
                end = mid;
            } else {
                return true;
            }
        }

        //System.out.println("start: " + start);

        int[] row = matrix[start];
        start = 0;
        end = row.length;

        int index = -1;

        while (start < end) {
            int mid = (start + end) >>> 1;
            int midValue = row[mid];

            if (midValue < target) {
                start = mid + 1;
            } else if (midValue > target) {
                end = mid;
            } else {
                index = mid;
                break;
            }
        }

        return index != -1;
    }
}
