/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class LongestCommonPrefix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] inputs = { "a", "a", "ab" };

        LongestCommonPrefix solution = new LongestCommonPrefix();
        String result = solution.longestCommonPrefix(inputs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];
        int i = 0;
        for (i = 0; i < first.length(); i ++) {
            char c = first.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || c != str.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }

        return first.substring(0, i);
    }
}
