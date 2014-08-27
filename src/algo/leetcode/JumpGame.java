/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class JumpGame {
    private Map<Integer, Boolean> resultMap = new HashMap<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] steps = new int[10 * 100 * 100];
        for (int i = 0; i < steps.length - 1; i++) {
            steps[i] = (steps.length - i) / 10 + 5;
        }

        steps = new int[] { 1, 0, 0 };

        JumpGame solution = new JumpGame();
        boolean result = solution.canJump(steps);

        System.out.println(result);
    }

    public boolean canJump(int[] steps) {
        if (steps == null || steps.length == 0) {
            return false;
        }
        if (steps.length == 1) {
            return true;
        }

        int maxReach = 0;

        for (int i = 0; i < steps.length; i ++) {
            if (i > maxReach) {
                return false;
            }

            int canReach = i + steps[i];

            if (canReach >= steps.length - 1) {
                return true;
            }

            if (canReach > maxReach) {
                maxReach = canReach;
            }
        }

        return false;
    }
}
