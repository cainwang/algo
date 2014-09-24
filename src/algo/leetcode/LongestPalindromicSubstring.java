/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class LongestPalindromicSubstring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String input = "ababababa";

        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String result = solution.longestPalindrome(input);

        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        String maxPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            if (i == 4) {
                System.out.println();
            }

            String result = findPalindromeLength(s, i, true);
            if (result.length() > maxPalindrome.length()) {
                maxPalindrome = result;
            }

            result = findPalindromeLength(s, i, false);
            if (result.length() > maxPalindrome.length()) {
                maxPalindrome = result;
            }

            if (s.length() - i < maxPalindrome.length() / 2) {
                break;
            }
        }

        return maxPalindrome;
    }

    private String findPalindromeLength(String s, int center, boolean inBetween) {
        int start, end;

        if (inBetween) {
            start = center - 1;
            end = center;
        } else {
            start = center - 1;
            end = center + 1;
        }

        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }

            start--;
            end++;
        }

        start ++;
        end --;

        if (start <= end) {
            return s.substring(start, end + 1);
        }

        return "";
    }
}
