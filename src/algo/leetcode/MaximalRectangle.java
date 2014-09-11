/**
 *
 */
package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cainwang
 *
 */
public class MaximalRectangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] matrix = { { '0', '1' }, { '1', '0' } };

        MaximalRectangle solution = new MaximalRectangle();
        int result = solution.maximalRectangle(matrix);

        System.out.println(result);
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        if (matrix == null || matrix.length == 0) {
            return maxArea;
        }
        int matrixWidth = matrix[0].length;

        for (int row = 0; row < matrix.length; row++) {
            int[] heights = new int[matrixWidth];

            for (int col = 0; col < matrixWidth; col++) {
                heights[col] = findHeight(matrix, row, col);
            }

            Deque<Integer> deque = new LinkedList<>();
            int i = 0;

            while (i < heights.length) {
                int height = heights[i];

                if (deque.isEmpty() || heights[deque.peekLast()] < height) {
                    deque.add(i++);
                } else {
                    int targetHeight = heights[deque.removeLast()];

                    int area = targetHeight * (deque.isEmpty() ? i : i - deque.peekLast() - 1);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }

            while (!deque.isEmpty()) {
                int targetHeight = heights[deque.removeLast()];

                int area = targetHeight * (deque.isEmpty() ? i : i - deque.peekLast() - 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public int findHeight(char[][] matrix, int row, int col) {
        int height = 0;

        for (int i = row; i >= 0; i--) {
            if (matrix[i][col] == '1') {
                height++;
            } else {
                break;
            }
        }

        return height;
    }
}
