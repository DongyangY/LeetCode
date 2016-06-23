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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
            
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        int min = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].end);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                min++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        
        return min;
    }
}