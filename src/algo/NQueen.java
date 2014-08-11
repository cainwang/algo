/**
 *
 */
package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class NQueen {
    private List<int[]> queensList = new LinkedList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        NQueen solution = new NQueen();
        List<String[]> results = solution.solveNQueens(1);

        for (String[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }

    public List<String[]> solveNQueens(int size) {
        int[] queens = new int[size];

        if (size == 1) {
            queens[0] = 0;
            queensList.add(queens);
        } else {
            for (int i = 0; i < size; i++) {
                queens[0] = i;
                findNextQueen(queens, 1, size);
            }
        }

        return produceResults(size);
    }

    private List<String[]> produceResults(int size) {
        List<String[]> results = new LinkedList<>();

        for (int[] queens : queensList) {
            String[] result = new String[size];

            for (int i = 0; i < size; i ++) {
                int queenCol = queens[i];

                char[] row = new char[size];
                Arrays.fill(row, '.');
                row[queenCol] = 'Q';

                result[i] = new String(row);
            }

            results.add(result);
        }

        return results;
    }

    public void findNextQueen(int[] queens, int row, int size) {
        for (int i = 0; i < size; i++) {
            if (!isThreatening(queens, row, i)) {
                queens[row] = i;

                if (row == size - 1) {
                    int[] result = new int[size];
                    System.arraycopy(queens, 0, result, 0, size);

                    queensList.add(result);
                    return;
                } else {
                    findNextQueen(queens, row + 1, size);
                }
            }
        }
    }

    private boolean isThreatening(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || (Math.abs(i - row) == Math.abs(queens[i] - col))) {
                return true;
            }
        }

        return false;
    }
}
