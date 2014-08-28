/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class Pow {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public double pow(double x, int n) {
        if (n < 0) {
            return pow(1 / x, -n);
        }

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }

        if ((n & 1) == 0) {
            return pow(x * x, n / 2);
        } else {
            return x * pow(x * x, (n - 1) / 2);
        }
    }
}
