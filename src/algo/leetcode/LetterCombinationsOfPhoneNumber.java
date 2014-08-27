/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cainwang
 *
 */
public class LetterCombinationsOfPhoneNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        List<String> results = solution.letterCombinations("2");
        System.out.println(results);
    }

    private Map<Character, String> keyMap = new HashMap<>();

    {
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        if (digits == null || digits.length() == 0) {
            result.add("");
        } else {
            findCombination(result, new StringBuilder(), digits, 0);
        }

        return result;
    }

    private void findCombination(List<String> result, StringBuilder builder, String digits, int index) {
        if (index == digits.length()) {
            result.add(builder.toString());
        } else {
            char c = digits.charAt(index);
            String keys = keyMap.get(c);

            if (keys == null) {
                return;
            }

            for (int i = 0; i < keys.length(); i++) {
                StringBuilder newBuilder = new StringBuilder(builder);
                newBuilder.append(keys.charAt(i));

                findCombination(result, newBuilder, digits, index + 1);
            }
        }
    }
}
