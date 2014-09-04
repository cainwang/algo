/**
 *
 */
package algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class Anagrams {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public List<String> anagrams(String[] strs) {
        List<String> results = new LinkedList<>();

        if (strs == null) {
            return results;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> values = map.get(key);
            if (values == null) {
                values = new LinkedList<String>();
                map.put(key, values);
            }
            values.add(str);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> values = entry.getValue();

            if (values.size() > 1) {
                results.addAll(values);
            }
        }

        return results;
    }
}
