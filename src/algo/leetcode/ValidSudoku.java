/**
 *
 */
package algo.leetcode;

import java.util.Arrays;

/**
 * @author cainwang
 *
 */
public class ValidSudoku {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] inputs = { ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
                "8........", "9........" };

        char[][] board = new char[9][9];
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];

            for (int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
            }
        }

        ValidSudoku solution = new ValidSudoku();
        boolean result = solution.isValidSudoku(board);

        System.out.println(result);
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }

        for (char[] row : board) {
            if (row == null || row.length != 9) {
                return false;
            }
        }

        int[] nums = new int[9];

        for (char[] row : board) {
            Arrays.fill(nums, 0);

            for (char c : row) {
                if (!verifyChar(c, nums)) {
                    return false;
                }
            }
        }

        for (int colNo = 0; colNo < board.length; colNo++) {
            Arrays.fill(nums, 0);

            for (int rowNo = 0; rowNo < board.length; rowNo++) {
                char c = board[rowNo][colNo];

                if (!verifyChar(c, nums)) {
                    return false;
                }
            }
        }

        for (int rowNo = 0; rowNo < 3; rowNo++) {
            for (int colNo = 0; colNo < 3; colNo++) {
                int startRow = rowNo * 3, startCol = colNo * 3;
                Arrays.fill(nums, 0);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[startRow + i][startCol + j];

                        if (!verifyChar(c, nums)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean verifyChar(char c, int[] nums) {
        if (c == '.') {
            return true;
        }

        int n = c - '0';
        if (n <= 0 || n > 9) {
            return false;
        }
        if (nums[n - 1] == 1) {
            return false;
        }

        nums[n - 1] = 1;
        return true;
    }
}
