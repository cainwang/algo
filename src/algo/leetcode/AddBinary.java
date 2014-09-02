/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class AddBinary {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String result = solution.addBinary("1010", "1011");
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        if (a.length() > b.length()) {
            String swap = a;
            a = b;
            b = swap;
        }

        boolean carryOne = false;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            int d1 = a.charAt(a.length() - i - 1) - '0';
            int d2 = b.charAt(b.length() - i - 1) - '0';

            int sum = d1 + d2;
            if (carryOne) {
                sum ++;
            }

            if (sum == 0) {
                builder.insert(0, '0');
                carryOne = false;
            } else if (sum == 1) {
                builder.insert(0, '1');
                carryOne = false;
            } else if (sum == 2) {
                builder.insert(0, '0');
                carryOne = true;
            } else if (sum == 3) {
                builder.insert(0, '1');
                carryOne = true;
            }
        }

        for (int i = b.length() - a.length() - 1; i >= 0; i--) {
            char c = b.charAt(i);

            if (carryOne) {
                if (c == '0') {
                    builder.insert(0, '1');
                    carryOne = false;
                } else if (c == '1') {
                    builder.insert(0, '0');
                    carryOne = true;
                }
            } else {
                builder.insert(0, c);
            }
        }

        if (carryOne) {
            builder.insert(0, '1');
        }

        return builder.toString();
    }
}
