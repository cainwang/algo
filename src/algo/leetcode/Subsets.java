/**
 *
 */
package algo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class Subsets {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] s = { 1, 2, 3 };

        Subsets solution = new Subsets();
        List<List<Integer>> result = solution.subsets(s);

        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] s) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());

        Arrays.sort(s);

        List<Integer> remains = new LinkedList<>();

        for (int num : s) {
            remains.add(num);
        }

        for (int i = 0; i < s.length; i++) {
            doSubset(result, new LinkedList<Integer>(), remains, i + 1);
        }

        return result;
    }

    private void doSubset(List<List<Integer>> result, List<Integer> head, List<Integer> remains, int level) {
        if (head.size() == level) {
            result.add(head);
        } else {
            for (int i = 0; i < remains.size(); i++) {
                int remain = remains.get(i);

                List<Integer> subset = new LinkedList<>(head);
                subset.add(remain);

                List<Integer> newRemains = remains.subList(i + 1, remains.size());
                doSubset(result, subset, newRemains, level);
            }
        }
    }
}
