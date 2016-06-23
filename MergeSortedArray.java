public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            if (j >= n) { merge[k++] = nums1[i++]; continue; }
            if (i >= m) { merge[k++] = nums2[j++]; continue; }
            if (nums1[i] <= nums2[j]) merge[k++] = nums1[i++];
            else merge[k++] = nums2[j++];
        }
        System.arraycopy(merge, 0, nums1, 0, m + n);
    }
}