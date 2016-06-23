public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0 || citations[n - 1] < 1) return 0;
        int l = 0, r = citations.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int h = n - mid;
            if (h == citations[mid]) return h;
            else if (h > citations[mid]) l = mid + 1;
            else r = mid;
        }
        return n - r;
    }
}