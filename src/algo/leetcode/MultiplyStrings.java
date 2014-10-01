/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class MultiplyStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        String result = solution.multiply("123", "000");

        System.out.println(result);
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num2.length(); i ++) {
            char c = num2.charAt(num2.length() - i - 1);

            StringBuilder product = multipleSingle(num1, c);
            for (int j = 0; j < i; j ++) {
                product.append('0');
            }

            result = add(result, product);
        }

        return result.toString();
    }

    private StringBuilder add(CharSequence num1, CharSequence num2) {
        StringBuilder builder = new StringBuilder();

        int maxLen = Math.max(num1.length(), num2.length());

        boolean carryOne = false;

        for (int i = 0; i < maxLen; i ++) {
            char c1 = '0';
            char c2 = '0';

            if (i < num1.length()) {
                c1 = num1.charAt(num1.length() - i - 1);
            }
            if (i < num2.length()) {
                c2 = num2.charAt(num2.length() - i - 1);
            }

            int sum = c1 - '0' + c2 - '0';

            if (carryOne) {
                sum ++;
            }

            if (sum > 9) {
                carryOne = true;
                sum -= 10;
            } else {
                carryOne = false;
            }

            builder.insert(0, sum);
        }

        if (carryOne) {
            builder.insert(0, 1);
        }

        for (int i = 0; i < builder.length() - 1; i ++) {
            if (builder.charAt(i) == '0') {
                builder.deleteCharAt(i);
                i --;
            } else {
                break;
            }
        }

        return builder;
    }

    private StringBuilder multipleSingle(CharSequence num, char digit) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < num.length(); i ++) {
            char c = num.charAt(num.length() - i - 1);

            int product = (c - '0') * (digit - '0');
            product += carry;

            if (product > 9) {
                carry = product / 10;
                product %= 10;
            } else {
                carry = 0;
            }

            builder.insert(0, product);
        }
        if (carry > 0) {
            builder.insert(0, carry);
        }

        for (int i = 0; i < builder.length() - 1; i ++) {
            if (builder.charAt(i) == '0') {
                builder.deleteCharAt(i);
                i --;
            } else {
                break;
            }
        }

        return builder;
    }
}
