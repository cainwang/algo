/**
 *
 */
package algo.leetcode;

/**
 * @author cainwang
 *
 */
public class ContainerWithMostWater {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[] { 1, 2, 3 }));
    }

    public int maxArea(int[] heights) {
        int maxArea = 0;
        int start = 0, end = heights.length - 1;

        while (start < end) {
            int startHeight = heights[start], endHeight = heights[end];

            int area = Math.min(startHeight, endHeight) * (end - start);
            if (area > maxArea) {
                maxArea = area;
            }

            if (startHeight < endHeight) {
                while (start < end && heights[start] <= startHeight) {
                    start ++;
                }
            } else {
                while (start < end && heights[end] <= endHeight) {
                    end --;
                }
            }
        }

        return maxArea;
    }
}
