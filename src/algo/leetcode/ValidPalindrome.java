/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class ValidPalindrome {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        boolean result = solution.isPalindrome("1a2");

        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int start = 0, end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            if (!Character.isLetterOrDigit(startChar)) {
                start ++;
                continue;
            }

            char endChar = s.charAt(end);
            if (!Character.isLetterOrDigit(endChar)) {
                end --;
                continue;
            }

            startChar = Character.toLowerCase(startChar);
            endChar = Character.toLowerCase(endChar);

            if (startChar != endChar) {
                return false;
            }

            start ++;
            end --;
        }

        return true;
    }
}
