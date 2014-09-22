/**
 *
 */
package algo.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cain
 *
 */
public class MergeIntervals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Interval> inputs = new LinkedList<>();
        inputs.add(new Interval(2, 3));
        inputs.add(new Interval(4, 5));
        inputs.add(new Interval(1, 10));

        MergeIntervals solution = new MergeIntervals();
        List<Interval> results = solution.merge(inputs);
        System.out.println(results);
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        for (int i = intervals.size() - 1; i >= 1; i--) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i - 1);

            if (current.start <= next.end) {
                next.end = Math.max(next.end, current.end);
                intervals.remove(i);

                for (int j = i; j < intervals.size(); j ++) {
                    Interval interval = intervals.get(j);
                    if (interval.start <= next.end) {
                        next.end = Math.max(next.end, interval.end);
                        intervals.remove(j);
                        j --;
                    } else {
                        break;
                    }
                }
            }
        }

        return intervals;
    }
}

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
