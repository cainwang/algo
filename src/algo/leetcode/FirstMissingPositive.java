/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class FirstMissingPositive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = {1, -1, 2};

        FirstMissingPositive solution = new FirstMissingPositive();
        int result = solution.firstMissingPositive(inputs);

        System.out.println(result);
    }

    public int firstMissingPositive(int[] a) {
        if (a == null || a.length == 0) {
            return 1;
        }

        for (int i = 0; i < a.length; i++) {
            int num = a[i];

            if (num > 0 && num < a.length && a[num - 1] != num) {
                a[i] = a[num - 1];
                a[num - 1] = num;

                i--;
            }
        }

        int i = 0;
        for (; i < a.length; i++) {
            int num = a[i];

            if (num <= 0) {
                break;
            } else if (i + 1 != num) {
                break;
            }
        }

        return i + 1;
    }
}
