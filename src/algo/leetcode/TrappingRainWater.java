/**
 *
 */
package algo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cainwang
 *
 */
public class TrappingRainWater {
    /**
     * @param args
     */
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int result = solution.trap(new int[] { 5, 4, 1, 2 });

        System.out.println(result);
    }

    public int trap(int[] a) {
        if (a == null || a.length < 3) {
            return 0;
        }

        List<Integer> leftTops = new LinkedList<>();
        List<Integer> rightTops = new LinkedList<>();

        int left = 0, right = a.length - 1;
        int leftTop = -1, rightTop = -1;

        while (left < right) {
            if (left != leftTop) {
                int leftHeight = a[left];

                if (leftHeight > a[left + 1]) {
                    if (leftTop == -1 || leftHeight > a[leftTop]) {
                        leftTop = left;
                        leftTops.add(left);
                    }
                }
            }

            if (right != rightTop) {
                int rightHeight = a[right];
                if (rightHeight > a[right - 1]) {
                    if (rightTop == -1 || rightHeight > a[rightTop]) {
                        rightTop = right;
                        rightTops.add(0, rightTop);
                    }
                }
            }

            if (leftTop == -1 || (rightTop != -1 && a[leftTop] <= a[rightTop])) {
                left++;
            }
            if (rightTop == -1 || (leftTop != -1 && a[leftTop] >= a[rightTop])) {
                right--;
            }
        }

        leftTops.addAll(rightTops);

        return calculateWater(a, leftTops);
    }

    private int calculateWater(int[] a, List<Integer> tops) {
        if (tops.size() < 2) {
            return 0;
        }

        int area = 0;

        for (int i = 0; i < tops.size() - 1; i++) {
            int leftHeightIndex = tops.get(i);
            int rightHeightIndex = tops.get(i + 1);

            int leftHeight = a[leftHeightIndex];
            int rightHeight = a[rightHeightIndex];

            int waterHeight = Math.min(leftHeight, rightHeight);
            int totalArea = (rightHeightIndex - leftHeightIndex - 1) * waterHeight;

            int bottomArea = 0;
            for (int j = leftHeightIndex + 1; j < rightHeightIndex; j++) {
                bottomArea += Math.min(a[j], waterHeight);
            }

            area += totalArea - bottomArea;
        }

        return area;
    }
}
