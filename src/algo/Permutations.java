/**
 *
 */
package algo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class Permutations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Permutations solution = new Permutations();
        List<List<Integer>> results = solution.permute(new int[] { 1, 2, 3 });
        System.out.println(results);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();

        if (nums.length > 0) {
            List<Integer> remains = new LinkedList<>();
            for (int num : nums) {
                remains.add(num);
            }

            doPermute(new LinkedList<Integer>(), remains, results);
        }

        return results;
    }

    private void doPermute(List<Integer> current, List<Integer> remains, List<List<Integer>> results) {
        if (remains.size() == 0) {
            results.add(current);
        } else {
            for (int i = 0; i < remains.size(); i++) {
                List<Integer> newRemains = new LinkedList<>(remains);
                List<Integer> newCurrent = new LinkedList<>(current);

                newCurrent.add(remains.get(i));
                newRemains.remove(i);

                doPermute(newCurrent, newRemains, results);
            }
        }
    }
}
