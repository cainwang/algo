/**
 *
 */
package algo;

/**
 * @author cainwang
 *
 */
public class LengthOfLastWord {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        int len = solution.lengthOfLastWord(" a");
        System.out.println(len);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int lastWordEnd = -1;

        for (int i = s.length() - 1; i >= 0; i --) {
            char c = s.charAt(i);

            if (c == ' ') {
                if (lastWordEnd != -1) {
                    return lastWordEnd - i;
                }
            } else {
                if (lastWordEnd == -1) {
                    lastWordEnd = i;
                }
            }
        }

        if (lastWordEnd == -1) {
            return 0;
        }

        return lastWordEnd + 1;
    }
}
