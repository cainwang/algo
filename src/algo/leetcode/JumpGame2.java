/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class JumpGame2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public int jump(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int steps = 0;
        int currentStepStart = 0;
        int currentStepMaxReach = 0;
        int nextStepMaxReach = 0;

        while (currentStepMaxReach < a.length - 1) {
            steps ++;

            for (int i = currentStepStart; i <= currentStepMaxReach; i ++) {
                int reach = i + a[i];

                if (reach > a.length - 1) {
                    nextStepMaxReach = reach;
                    break;
                } else if (reach > nextStepMaxReach) {
                    nextStepMaxReach = reach;
                }
            }

            currentStepStart = currentStepMaxReach + 1;
            currentStepMaxReach = nextStepMaxReach;
        }

        return steps;
    }
}
