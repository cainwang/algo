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
public class PascalTriangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> list = solution.generate(5);
        System.out.println(list);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> previousRow = null;

        for (int i = 0; i < numRows; i ++) {
            List<Integer> row = new LinkedList<>();
            result.add(row);

            for (int j = 0; j <= i; j ++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else if (previousRow != null) {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }

            previousRow = row;
        }

        return result;
    }
}
