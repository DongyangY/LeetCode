public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0) {
                nums1[k] = nums1[i--];
            } else if (i < 0) {
                nums1[k] = nums2[j--];
            } else {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i--];
                } else {
                    nums1[k] = nums2[j--];
                }
            }
        }
    }
}