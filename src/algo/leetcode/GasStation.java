/**
 *
 */
package algo.leetcode;

/**
 * @author Cain
 *
 */
public class GasStation {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int lowestFuel = 0;
        int lowestIndex = -1;

        int fuel = 0;

        for (int i = 0; i < gas.length; i ++) {
            fuel = fuel + gas[i] - cost[i];

            if (fuel < lowestFuel) {
                lowestFuel = fuel;
                lowestIndex = i;
            }
        }

        if (fuel < 0) {
            return -1;
        }

        if (lowestIndex == gas.length - 1) {
            lowestIndex = 0;
        }

        return lowestIndex + 1;
    }
}
