package algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {
    private Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int size = 100;
        int[][] grid = new int[size][size];

        for (int i = 0; i < size; i ++) {
            int[] row = grid[i];
            Arrays.fill(row, i);
        }

        MinimumPathSum solution = new MinimumPathSum();
        int sum = solution.minPathSum(grid);

        System.out.println(sum);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] firstRow = grid[0];
        int totalCol = firstRow.length;

        return traverse(grid, 0, 0, totalCol);
    }

    private int traverse(int[][] grid, int row, int col, int totalCol) {
        int loc = row * totalCol + col;
        Integer cachedSum = cache.get(loc);

        if (cachedSum != null) {
            return cachedSum;
        } else {
            int cell = grid[row][col];

            if (row == grid.length - 1 && col == totalCol - 1) {
                return cell;
            } else {
                int sum = cell, sum1 = -1, sum2 = -1;

                if (row < grid.length - 1) {
                    sum1 = traverse(grid, row + 1, col, totalCol);
                }
                if (col < totalCol - 1) {
                    sum2 = traverse(grid, row, col + 1, totalCol);
                }

                if (sum1 != -1 && sum2 != -1) {
                    sum += Math.min(sum1, sum2);
                } else if (sum1 == -1) {
                    sum += sum2;
                } else if (sum2 == -1) {
                    sum += sum1;
                }

                cache.put(loc, sum);
                return sum;
            }
        }
    }
}
