public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // K: sum, V: index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            // Store the furthest index
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return maxLen;
    }
}