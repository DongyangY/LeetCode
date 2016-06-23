public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int index = hm.get(nums[i]);
                result[0] = index + 1;
                result[1] = i + 1;
            } else {
                hm.put(target - nums[i], i);
            }
        }
        return result;
    }
}