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
public class PlusOne {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] result = solution.plusOne(new int[] {1, 1, 9});
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        List<Integer> bits = new LinkedList<>();

        boolean carryOne = true;
        for (int i = digits.length - 1; i >= 0; i --) {
            int digit = digits[i];

            if (carryOne) {
                if (digit == 9) {
                    digit = 0;
                    carryOne = true;
                } else {
                    digit ++;
                    carryOne = false;
                }
            }

            bits.add(digit);
        }
        if (carryOne) {
            bits.add(1);
        }

        int[] result = new int[bits.size()];
        for (int i = 0; i < result.length; i ++) {
            result[i] = bits.get(result.length - i - 1);
        }

        return result;
    }
}
