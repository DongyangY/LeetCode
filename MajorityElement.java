public class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    public int majorityElement(int[] nums, int lp, int rp) {
        if (lp == rp) return nums[lp];
        int mp = lp + (rp - lp) / 2;
        int lm = majorityElement(nums, lp, mp);
        int rm = majorityElement(nums, mp + 1, rp);
        if (lm == rm) return lm;
        else {
            int lc = countElement(nums, lp, mp, lm);
            int rc = countElement(nums, mp + 1, rp, rm);
            return lc > rc ? lm : rm;
        }
    }
    
    public int countElement(int[] nums, int lp, int rp, int target) {
        int c = 0;
        for (int i = lp; i <= rp; i++) {
            if (nums[i] == target) c++;
        }
        return c;
    }
}