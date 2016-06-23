public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        int prev = lower - 1;
        int rear = upper + 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i == nums.length) ? rear : nums[i];
            if ((curr - prev) > 1) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            
            // Two-pass or two-pointer
            prev = curr;
        }
        
        return ranges;
    }
    
    private String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to; 
    }
}