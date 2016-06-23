public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        
        int n = nums.length;
        int median = findMedian(nums, 0, n - 1, (n - 1) / 2);
        
        int left = 0;
        int right = n - 1;
        int j = 0;
        while (j <= right) {
            if (nums[j] < nums[median]) {
                swap(nums, j, left);
                j++;
                left++;
            } else if (nums[j] > nums[median]) {
                swap(nums, j, right);
                right--;
            } else {
                j++;
            }
        }
        
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0 ,n);
        
        left = (n - 1) / 2;
        right = n - 1;
        
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
        
    }
    
    private int findMedian(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) return lo;
        int pivot = partition(nums, lo, hi);
        if (pivot == k) return pivot;
        else if (pivot > k)
            return findMedian(nums, lo, pivot - 1, k);
        else 
            return findMedian(nums, pivot + 1, hi, k);
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
        
        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] >= pivot) j--;
            
            if (i <= j) {
                swap(nums, i, j);
            }
        }
        
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}