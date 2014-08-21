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
public class Combination {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Combination solution = new Combination();
        List<List<Integer>> results = solution.combine(4, 2);

        System.out.println(results);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new LinkedList<>();

        List<Integer> current = new LinkedList<>();

        List<Integer> remains = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            remains.add(i);
        }

        doCombine(current, remains, k, results);

        return results;
    }

    private void doCombine(List<Integer> current, List<Integer> remains, int k, List<List<Integer>> results) {
        if (k == 0) {
            results.add(current);
        } else {
            for (int i = 0; i < remains.size(); i ++) {
                List<Integer> result = new LinkedList<>(current);
                result.add(remains.get(i));

                List<Integer> newRemains = remains.subList(i + 1, remains.size());

                doCombine(result, newRemains, k - 1, results);
            }
        }
    }
}
