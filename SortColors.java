public class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int i = 0, j = 0;
        while (j <= 2) {
            if (count[j] != 0) {
                nums[i++] = j;
                count[j]--;
            } else {
                j++;
            }
        }
    }
}