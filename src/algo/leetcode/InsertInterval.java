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
public class InsertInterval {
    public static void main(String[] args) {
        List<Interval> inputs = new LinkedList<>();
        inputs.add(new Interval(1, 5));
        inputs.add(new Interval(6, 8));

        Interval newInterval = new Interval(5, 6);

        InsertInterval solution = new InsertInterval();
        solution.insert(inputs, newInterval);

        System.out.println(inputs);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }

        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }

        int insertIndex = -1;

        for (int i = intervals.size() - 1; i >= 0; i--) {
            Interval interval = intervals.get(i);

            if (overlaps(interval, newInterval)) {
                interval.start = Math.min(interval.start, newInterval.start);
                interval.end = Math.max(interval.end, newInterval.end);

                if (insertIndex != -1) {
                    intervals.remove(insertIndex);
                }

                insertIndex = i;
                newInterval = interval;
            } else if (interval.end < newInterval.start) {
                if (insertIndex == -1) {
                    intervals.add(i + 1, newInterval);
                }
                break;
            } else  if (i == 0) {
                if (insertIndex == -1) {
                    intervals.add(0, newInterval);
                }
            }
        }

        return intervals;
    }

    private boolean overlaps(Interval a, Interval b) {
        return (a.start <= b.start && b.start <= a.end) || (b.start <= a.start && a.start <= b.end);
    }
}
