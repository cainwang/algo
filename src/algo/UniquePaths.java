/**
 *
 */
package algo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class UniquePaths {
    private Map<Integer, Integer> cache = new HashMap<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        int size = 3;

        UniquePaths solution = new UniquePaths();
        int total = solution.uniquePaths(size, size);

        System.out.println(total);
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }

        return traverse(0, 0, m, n);
    }

    public int traverse(int m, int n, int M, int N) {
        if (m == M - 1 && n == N - 1) {
            return 1;
        } else {
            int total = 0;
            int loc = m * N + n;

            Integer cachedValue = cache.get(loc);
            if (cachedValue != null) {
                total = cachedValue.intValue();
            } else {
                if (m < M - 1) {
                    total += traverse(m + 1, n, M, N);
                }
                if (n < N - 1) {
                    total += traverse(m, n + 1, M, N);
                }

                cache.put(loc, total);
            }

            return total;
        }
    }
}
