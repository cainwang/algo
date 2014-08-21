/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cainwang
 *
 */
public class CountAndSay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        String result = solution.countAndSay(10);

        System.out.println(result);
    }

    public String countAndSay(int n) {
        List<Integer> result = new LinkedList<>();
        result.add(1);

        for (int i = 1; i < n; i ++) {
            result = countNext(result);
        }

        StringBuilder buf = new StringBuilder();
        for (int i : result) {
            buf.append(i);
        }

        return buf.toString();
    }

    public List<Integer> countNext(List<Integer> digits) {
        List<Integer> result = new LinkedList<>();
        int previousDigit = -1;
        int count = 0;

        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);

            if (previousDigit == -1) {
                previousDigit = digit;
                count = 1;
            } else {
                if (digit == previousDigit) {
                    count++;
                } else {
                    addDigit(result, count, previousDigit);
                    previousDigit = digit;
                    count = 1;
                }
            }

            if (i == digits.size() - 1) {
                addDigit(result, count, previousDigit);
            }
        }

        return result;
    }

    private void addDigit(List<Integer> result, int count, int digit) {
        result.add(count);
        result.add(digit);
    }
}
