/**
 *
 */
package algo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class UniquePaths2 {
    private Map<Integer, Integer> pathMap = new HashMap<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = { { 1, 0 } };

        UniquePaths2 solution = new UniquePaths2();
        int paths = solution.uniquePathsWithObstacles(matrix);
        System.out.println(paths);
    }

    public int uniquePathsWithObstacles(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0][0] == 1) {
            return 0;
        }

        int totalRow = matrix.length;
        int totalCol = matrix[0].length;

        return doPath(matrix, 0, 0, totalRow, totalCol);
    }

    private int doPath(int[][] matrix, int row, int col, int totalRow, int totalCol) {
        if (row == totalRow - 1 && col == totalCol - 1 && matrix[row][col] == 0) {
            return 1;
        }

        int loc = row * totalCol + col;
        Integer cache = pathMap.get(loc);
        if (cache != null) {
            return cache;
        }

        int countDown = 0;
        if (row < totalRow - 1) {
            if (matrix[row + 1][col] == 0) {
                countDown = doPath(matrix, row + 1, col, totalRow, totalCol);
            }
        }

        int countRight = 0;
        if (col < totalCol - 1) {
            if (matrix[row][col + 1] == 0) {
                countRight = doPath(matrix, row, col + 1, totalRow, totalCol);
            }
        }

        int paths = countDown + countRight;
        pathMap.put(loc, paths);

        return paths;
    }
}
