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
        Pow solution = new Pow();
        double result = solution.pow(1, -2147483648);
        System.out.println(result);
    }

    public double pow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            return (n % 2 == 0) ? 1 : -1;
        }

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
