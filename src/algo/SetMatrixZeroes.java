/**
 *
 */
package algo;

import java.util.Arrays;

/**
 * @author Cain
 *
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 0, 1, 2 } };

        SetMatrixZeroes solution = new SetMatrixZeroes();
        solution.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int[] firstArray = matrix[0];
        if (firstArray.length == 0) {
            return;
        }

        int totalRow = matrix.length, totalCol = firstArray.length;

        boolean firstColZero = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int row = 0; row < totalRow; row++) {
            int[] array = matrix[row];

            for (int col = 1; col < totalCol; col++) {
                if (array[col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int col = 1; col < totalCol; col++) {
            if (firstArray[col] == 0) {
                for (int row = 1; row < totalRow; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int row = 0; row < totalRow; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < totalCol; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstColZero) {
            for (int row = 0; row < totalRow; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
