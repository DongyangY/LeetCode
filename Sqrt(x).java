public class Solution {
    public int mySqrt(int x) {
        long start = 1, end = (long)x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sqrt = mid * mid;
            if (sqrt == (long)x) return (int)mid;
            else if (sqrt < (long)x) start = mid + 1;
            else end = mid - 1;
        }
        return (int)end;
    }
}