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
public class PalindromePartitioning {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> results = solution.partition("aab");
        System.out.println(results);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> results = new LinkedList<>();

        if (s == null || s.length() == 0) {
            return results;
        }

        findPalindrome(results, new LinkedList<String>(), s, 0);

        return results;
    }

    private void findPalindrome(List<List<String>> results, List<String> result, String s, int start) {
        if (start == s.length()) {
            results.add(result);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                List<String> newResult = new LinkedList<>(result);
                newResult.add(s.substring(start, i + 1));

                findPalindrome(results, newResult, s, i + 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
