public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = occur.get(nums[i]);
            if (index == null) occur.put(nums[i], i);
            else if (i - index <= k) return true;
            else occur.put(nums[i], i);
        }
        return false;
    }
}