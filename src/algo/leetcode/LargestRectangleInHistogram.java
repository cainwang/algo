/**
 *
 */
package algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cainwang
 *
 */
public class LargestRectangleInHistogram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = {2, 2, 3};

        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int result = solution.largestRectangleArea(inputs);

        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int maxArea = 0;

        int i = 0;
        while (i < heights.length) {
            int height = heights[i];

            if (deque.isEmpty() || height > heights[deque.peekLast()]) {
                deque.add(i ++);
            } else {
                int targetHeight = heights[deque.removeLast()];

                int area = targetHeight * (deque.isEmpty() ? i : i - deque.peekLast() - 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!deque.isEmpty()) {
            int targetHeight = heights[deque.removeLast()];

            int area = targetHeight * (deque.isEmpty() ? i : i - deque.peekLast() - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
