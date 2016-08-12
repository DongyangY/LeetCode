public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return null;
        int n = nums.length;
        if (n == 0) return new int[0];
        
        int[] result = new int[n - k + 1];
        
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && i - q.peekFirst() >= k) {
                q.removeFirst();
            }
            
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            
            q.add(i);
            
            if (i >= k - 1) result[i - k + 1] = nums[q.peekFirst()];
        }
        
        return result;
    }
}