/**
 *
 */
package algo;

/**
 * @author cainwang
 *
 */
public class PalindromeNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        boolean result = solution.isPalindrome(-2147447412);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int len = 0;
        int a = x;

        while (a != 0) {
            len ++;
            a /= 10;
        }

        if (len < 2) {
            return true;
        }

        a = x;
        for (int i = 0; i < len / 2; i ++) {
            int digit1 = a % 10;

            int highDivider = (int)Math.pow(10, len - 1 - i * 2);
            int digit2 = a / highDivider;


            if (digit1 != digit2) {
                return false;
            }

            a = a % highDivider;
            a /= 10;
        }

        return true;
    }
}
