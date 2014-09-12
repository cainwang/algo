/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class StrStr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StrStr solution = new StrStr();
        String result = solution.strStr("aaa", "a");

        System.out.println(result);
    }

    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        if (haystack.length() < needle.length()) {
            return null;
        }
        if (haystack.equals(needle)) {
            return needle;
        }
        if (needle.length() == 0) {
            return haystack.substring(0, 1);
        }

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            char c = haystack.charAt(i);

            if (c == needle.charAt(0)) {
                boolean match = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return haystack.substring(i);
                }
            }
        }

        return null;
    }
}
