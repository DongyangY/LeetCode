/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }    
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        int i = 0, j = 1;
        while (j < intervals.size()) {
            if (intervals.get(i).end >= intervals.get(j).start) {
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(j).end);
                intervals.remove(j);
            } else {
                i++;
                j++;
            }
        }
        return intervals;
    }
}