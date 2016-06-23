public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closet = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int small = i + 1;
            int large = nums.length - 1;
            
            while (small < large) {
                int sum = nums[i] + nums[small] + nums[large];
                
                if (sum > target) large--;
                else if (sum < target) small++;
                else return target;
                
                int diff = Math.abs(target - sum);
                if (diff < min) {
                    min = diff;
                    closet = sum;
                }
            }
        }
        
        return closet;
    }
}