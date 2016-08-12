public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] num = new int[n + 1];
        for (int i : citations) {
            int k = i <= n ? i : n;
            num[k]++;
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            if (num[i] + sum >= i) {
                return i;
            } else {
                sum += num[i];
            }
        }
        return 0;
    }
}