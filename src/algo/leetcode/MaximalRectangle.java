/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cainwang
 *
 */
public class MaximalRectangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] matrix = { { '1', '1' }, {'1', '0'} };

        MaximalRectangle solution = new MaximalRectangle();
        int result = solution.maximalRectangle(matrix);

        System.out.println(result);
    }

    private Map<Integer, int[]> cache = new HashMap<>();

    private int matrixWidth;

    private int maxArea;

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        matrixWidth = matrix[0].length;

        traverse(matrix, 0, 0);

        return maxArea;
    }

    private int[] traverse(char[][] matrix, int row, int col) {
        int key = row * matrixWidth + col;
        int[] result = cache.get(key);

        if (result != null) {
            return result;
        }

        int value = matrix[row][col];

        int[] below = null;
        int[] right = null;
        int[] corner = null;

        if (row < matrix.length - 1) {
            below = traverse(matrix, row + 1, col);
        }
        if (col < matrixWidth - 1) {
            right = traverse(matrix, row, col + 1);
        }
        if (row < matrix.length - 1 && col < matrixWidth - 1) {
            corner = traverse(matrix, row + 1, col + 1);
        }


        if (value == '1') {
            if (below != null && right != null) {
                int plusRightWidth = right[0] + 1;
                int plusRightHeight = Math.min(below[1], right[1] - 1) + 1;
                int plusRightArea = plusRightWidth * plusRightHeight;

                int plusBelowWidth = Math.min(below[0] - 1, right[1]) + 1;
                int plusBelowHeight = below[1] + 1;
                int plusBelowArea = plusBelowWidth * plusBelowHeight;

                if (corner != null) {
                    int plusCornerWidth = Math.min(corner[0], right[0]) + 1;
                    int plusCornerHeight = Math.min(corner[1], below[1]) + 1;
                }
            } else if (below != null) {
                result = new int[] { 1, below[1] + 1 };
            } else if (right != null) {
                result = new int[] { right[0] + 1, 1 };
            } else {
                result = new int[] { 1, 1 };
            }

            int area = result[0] * result[1];
            if (area > maxArea) {
                maxArea = area;
            }
        }

        cache.put(key, result);

        return result;
    }
}
