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
 * @author cainwang
 *
 */
public class Triangle {
    private Map<Integer, Integer> sumMap = new HashMap<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(-2, -3));
        // triangle.add(Arrays.asList(4, 5, 6));

        Triangle solution = new Triangle();
        int sum = solution.minimumTotal(triangle);

        System.out.println(sum);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        } else {
            if (triangle.get(0).size() == 0) {
                return 0;
            }
        }

        return findMinSum(triangle, 0, 0);
    }

    private int findMinSum(List<List<Integer>> triangle, int level, int start) {
        int loc = triangle.size() * level + start;
        if (sumMap.get(loc) != null) {
            return sumMap.get(loc);
        }

        List<Integer> row = triangle.get(level);
        int val = row.get(start);

        int sum = val;

        level++;
        if (level < triangle.size()) {
            int leftSum = findMinSum(triangle, level, start);
            int rightSum = findMinSum(triangle, level, start + 1);

            sum += Math.min(leftSum, rightSum);
        }

        sumMap.put(loc, sum);

        return sum;
    }

}
