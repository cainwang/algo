/**
 *
 */
package algo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class PascalTriangle2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PascalTriangle2 solution = new PascalTriangle2();
        List<Integer> row = solution.getRow(3);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = null;
        List<Integer> previousRow = null;

        for (int i = 0; i <= rowIndex; i ++) {
            row = new LinkedList<>();
            for (int j = 0; j <= i; j ++) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }

            previousRow = row;
        }

        return row;
    }
}
