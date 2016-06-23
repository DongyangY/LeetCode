public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] m = new int[n + 1];
        for (int c : citations) {
            if (c >= n) m[n]++;
            else m[c]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += m[i];
            if (count >= i) return i;
        }
        return 0;
    }
}