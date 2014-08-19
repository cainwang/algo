/**
 *
 */
package algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author cainwang
 *
 */
public class LongestConsecutiveSequence {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] source = { 7, -9, 3, -6, 3, 5, 3, 6, -2, -5, 8, 6, -4, -6, -4, -4, 5, -9, 2, 7, 0, 0 };

        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int result = solution.longestConsecutive(source);

        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, List<Integer>> headMap = new HashMap<>();
        Map<Integer, List<Integer>> tailMap = new HashMap<>();

        for (int num : nums) {
            int before = num - 1;
            int after = num + 1;

            List<Integer> afterList = headMap.get(after);
            List<Integer> beforeList = tailMap.get(before);

            if (afterList == null && beforeList == null) {
                List<Integer> list = new LinkedList<>();
                list.add(num);

                if (headMap.get(num) == null && tailMap.get(num) == null) {
                    headMap.put(num, list);
                    tailMap.put(num, list);
                }
            } else if (afterList != null && beforeList != null) {
                beforeList.add(num);
                beforeList.addAll(afterList);

                headMap.remove(after);
                tailMap.remove(before);

                int tail = beforeList.get(beforeList.size() - 1);
                List<Integer> existingList = tailMap.get(tail);

                if (existingList == null || existingList.size() < beforeList.size()) {
                    tailMap.put(tail, beforeList);
                }
            } else if (afterList != null) {
                afterList.add(0, num);
                headMap.remove(after);

                List<Integer> existingList = headMap.get(num);
                if (existingList == null || existingList.size() < afterList.size()) {
                    headMap.put(num, afterList);
                }
            } else if (beforeList != null) {
                beforeList.add(num);
                tailMap.remove(before);

                List<Integer> existingList = tailMap.get(num);
                if (existingList == null || existingList.size() < beforeList.size()) {
                    tailMap.put(num, beforeList);
                }
            }

        }

        int maxLen = 0;

        for (Map.Entry<Integer, List<Integer>> entry : headMap.entrySet()) {
            List<Integer> list = entry.getValue();

            if (list.size() > maxLen) {
                maxLen = list.size();
            }
        }

        return maxLen;
    }

}
