/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class RotateImage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};

        RotateImage solution = new RotateImage();
        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j ++) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix.length; col ++) {
                if (col >= row && col < matrix.length - 1 - row) {
                    rotatePixel(matrix, row, col);
                }
            }
        }
    }

    private void rotatePixel(int[][] matrix, int row, int col) {
        int value = matrix[row][col];

        for (int i = 0; i < 4; i ++) {
            int nextCellRow = matrix.length - 1 - col;
            int nextCellCol = row;

            if (i == 3) {
                matrix[row][col] = value;
            } else {
                matrix[row][col] = matrix[nextCellRow][nextCellCol];
            }

            row = nextCellRow;
            col = nextCellCol;
        }
    }
}
