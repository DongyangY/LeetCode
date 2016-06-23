public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer c = ts.ceiling(nums[i]);
            Integer f = ts.floor(nums[i]);
            
            // Tree structure to get nearest values
            if ((c != null && nums[i] >= c - t) || (f != null && nums[i] <= f + t)) {
                return true;  
            } 
            ts.add(nums[i]);
            
            // Sliding k window
            if (i >= k) ts.remove(nums[i - k]);
        }
        return false;
    }
}