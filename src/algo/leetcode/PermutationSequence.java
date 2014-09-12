/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class PermutationSequence {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        String result = solution.getPermutation(3, 3);

        System.out.println(result);
    }

    public String getPermutation(int n, int k) {
        k --;

        List<Integer> remains = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            remains.add(i);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = n; i > 1; i--) {
            int subFactorial = findFactorial(i - 1);
            int result = k / subFactorial;

            int digit = findDigit(remains, result);

            builder.append(digit);
            remains.remove((Integer) digit);

            k = k % subFactorial;
        }
        builder.append(remains.get(0));

        return builder.toString();
    }

    private int findFactorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private int findDigit(List<Integer> remains, int no) {
        for (int i = 0; i < remains.size(); i++) {
            if (i == no) {
                return remains.get(i);
            }
        }

        return 0;
    }
}
