/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cainwang
 *
 */
public class SpiralMatrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] inputs = {{2, 3}};

        SpiralMatrix solution = new SpiralMatrix();
        List<Integer> results = solution.spiralOrder(inputs);

        System.out.println(results);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new LinkedList<>();

        if (matrix == null || matrix.length == 0) {
            return results;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        if (cols == 0) {
            return results;
        }

        int row = 0, col = 0, padding = 0;
        String direction = "right";

        boolean canContinue = true, moved = true;

        while (canContinue) {
            if (moved) {
                results.add(matrix[row][col]);
            }

            switch (direction) {
            case "right":
                int rightBound = cols - 1 - padding;
                if (col == rightBound) {
                    if (!moved) {
                        canContinue = false;
                    }

                    direction = "down";
                    moved = false;
                } else if (col < rightBound) {
                    col ++;
                    moved = true;
                } else {
                    canContinue = false;
                }

                break;
            case "down":
                int bottomBound = rows - 1 - padding;
                if (row == bottomBound) {
                    if (!moved) {
                        canContinue = false;
                    }

                    direction = "left";
                    moved = false;
                } else if (row < bottomBound) {
                    row ++;
                    moved = true;
                } else {
                    canContinue = false;
                }

                break;
            case "left":
                int leftBound = padding;
                if (col == leftBound) {
                    if (!moved) {
                        canContinue = false;
                    }

                    direction = "up";
                    moved = false;
                    padding ++;
                } else if (col > leftBound) {
                    col --;
                    moved = true;
                } else {
                    canContinue = false;
                }

                break;
            case "up":
                int topBound = padding;
                if (row == topBound) {
                    if (!moved) {
                        canContinue = false;
                    }

                    direction = "right";
                    moved = false;
                } else if (row > topBound) {
                    row --;
                    moved = true;
                } else {
                    canContinue = false;
                }

                break;
            }
        }

        return results;
    }
}
