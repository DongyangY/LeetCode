public class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        
        if (last == -1) return 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (last >= 0 && nums[last] == val) last--;
            if (i > last) break;
            if (nums[i] == val) swap(nums, i, last--);
        }
        
        return last + 1;
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}