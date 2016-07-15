public class HitCounter {
    
    int[] times, hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int t = timestamp % 300;
        if (times[t] == timestamp) {
            hits[t]++;
        } else {
            times[t] = timestamp;
            hits[t] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                sum += hits[i];
            }
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */