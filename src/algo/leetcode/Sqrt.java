/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class Sqrt {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Sqrt solution = new Sqrt();
        int result = solution.sqrt(4);

        System.out.println(result);
    }

    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        } else if (x > 0) {
            int start = 1;
            int end = x / 2 + 1;

            while (start <= end) {
                int m = (start + end) / 2;
                int result = x / m;

                if (m <= result && (m + 1) > x / (m + 1)) {
                    return m;
                }

                if (result < m) {
                    end = m - 1;
                } else {
                    start = m + 1;
                }
            }
        }

        return 0;
    }
}
