public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0 || citations[n - 1] < 1) return 0;
        int i = 0, j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (citations[mid] >= n - mid) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return n - j;
    }
}