/*
          |    
    |     |
    |   | | |
    | | | | |
    ---------------
    
    (i - j) * Min(ai, aj)
*/


public class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxArea = 0;
        
        while (lo < hi) {
            maxArea = Math.max(maxArea, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] >= height[hi]) hi--;
            else lo++;
        }
        
        return maxArea;
    }
}