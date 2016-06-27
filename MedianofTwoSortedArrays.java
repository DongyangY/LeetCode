public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (n + m) / 2;
        if ((m + n) % 2 == 0) {
            int left = findKth(nums1, 0, m, nums2, 0, n, mid);
            int right = findKth(nums1, 0, m, nums2, 0, n, mid + 1);
            return (left + right) / 2.0;
        } else {
            return findKth(nums1, 0, m, nums2, 0, n, mid + 1);
        }
    }
    
    private int findKth(int[] nums1, int start1, int end1, int nums2[], int start2, int end2, int k) {
        int m = end1 - start1;
        int n = end2 - start2;
        
        if (m == 0) return nums2[start2 + k - 1];
        if (n == 0) return nums1[start1 + k - 1];
        
        if (k == 1) return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        
        int mid1 = start1 + (end1 - start1) / 2;
        int mid2 = start2 + (end2 - start2) / 2;
        
        if (nums1[mid1] <= nums2[mid2]) {
            if (m / 2 + n / 2 + 1 >= k) {
                return findKth(nums1, start1, end1, nums2, start2, mid2, k);
            } else {
                return findKth(nums1, mid1 + 1, end1, nums2, start2, end2, k - m / 2 - 1);
            }
        } else {
            if (m / 2 + n / 2 + 1 >= k) {
                return findKth(nums1, start1, mid1, nums2, start2, end2, k);
            } else {
                return findKth(nums1, start1, end1, nums2, mid2 + 1, end2, k - n / 2 - 1);
            }
        }
    }
}