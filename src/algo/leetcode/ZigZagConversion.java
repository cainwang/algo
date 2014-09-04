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
public class ZigZagConversion {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";

        ZigZagConversion solution = new ZigZagConversion();
        String result = solution.convert(input, 3);

        System.out.println(result);
    }

    public String convert(String s, int nRows) {
        if (s == null || nRows < 1) {
            return null;
        };
        if (nRows == 1) {
            return s;
        }

        List<StringBuilder> lines = new LinkedList<>();
        for (int i = 0; i < nRows; i ++) {
            lines.add(new StringBuilder());
        }

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);

            int mod = i % (nRows * 2 - 2);

            if (mod == 0) {
                lines.get(0).append(c);
            } else if (mod == nRows - 1) {
                lines.get(nRows - 1).append(c);
            } else if (mod < nRows - 1) {
                lines.get(mod).append(c);
            } else {
                lines.get(nRows * 2 - 2 - mod).append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : lines) {
            result.append(builder);
        }

        return result.toString();
    }
}
