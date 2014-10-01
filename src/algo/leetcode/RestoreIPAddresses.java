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
public class RestoreIPAddresses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();
        List<String> results = solution.restoreIpAddresses("010010");

        System.out.println(results);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new LinkedList<>();

        findIps(s, 0, 4, new StringBuilder(), results);

        return results;
    }

    private void findIps(String s, int start, int remainingParts, StringBuilder result, List<String> results) {
        int maxLen = remainingParts * 3;
        int remainingLen = s.length() - start;
        if (remainingLen > maxLen || remainingLen < remainingParts) {
            return;
        }

        if (remainingParts == 1) {
            String part = getIpPart(s, start, s.length());
            if (part != null) {
                result.append('.').append(part);

                results.add(result.toString());
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (start + i > s.length()) {
                    continue;
                }

                String part = getIpPart(s, start, start + i);
                if (part != null) {
                    StringBuilder newResult = new StringBuilder(result);
                    if (newResult.length() > 0) {
                        newResult.append('.');
                    }
                    newResult.append(part);

                    findIps(s, start + i, remainingParts - 1, newResult, results);
                }
            }
        }
    }

    private String getIpPart(String s, int start, int end) {
        if (end - start > 1 && s.charAt(start) == '0') {
            return null;
        }

        String subString = s.substring(start, end);
        int part = Integer.parseInt(subString);

        if (part > 255) {
            return null;
        }

        return subString;
    }
}
