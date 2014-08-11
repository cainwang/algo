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
public class GrayCode {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        List<Integer> result = solution.grayCode(3);
        System.out.println(result);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();

        if (n <= 1) {
            result.add(0);

            if (n == 1) {
                result.add(1);
            }
        } else if (n == 1) {
            result.add(1);
        } else {
            int head = (int)Math.pow(2, n - 1);
            List<Integer> base = grayCode(n - 1);

            result.addAll(base);

            for (int i = base.size() - 1; i >= 0; i --) {
                result.add(base.get(i) + head);
            }
        }

        return result;
    }
}
