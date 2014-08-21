/**
 *
 */
package algo.leetcode;

import java.util.Arrays;


/**
 * @author cainwang
 *
 */
public class SpiralMatrix2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpiralMatrix2 solution = new SpiralMatrix2();
        int[][] matrix = solution.generateMatrix(2);
        System.out.println(Arrays.toString(matrix));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        String direction = "right";
        int row = 0, col = 0;

        for (int i = 1; i <= n * n; i++) {
            matrix[row][col] = i;

            switch (direction) {
            case "up":
                if (row == 0 || matrix[row - 1][col] > 0) {
                    direction = "right";
                    col ++;
                } else {
                    row--;
                }

                break;
            case "down":
                if (row == n - 1 || matrix[row + 1][col] > 0) {
                    direction = "left";
                    col --;
                } else {
                    row++;
                }

                break;
            case "left":
                if (col == 0 || matrix[row][col - 1] > 0) {
                    direction = "up";
                    row --;
                } else {
                    col--;
                }

                break;
            case "right":
                if (col == n - 1 || matrix[row][col + 1] > 0) {
                    direction = "down";
                    row ++;
                } else {
                    col++;
                }

                break;
            }
        }

        return matrix;
    }
}
