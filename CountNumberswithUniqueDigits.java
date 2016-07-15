public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) sum += 10;
            else {
                int product = 9;
                int start = 9;
                int t = i;
                while (--t > 0) {
                    product *= start;
                    if (product == 0) break;
                    start--;
                }
                sum += product;
            }
        }
        return sum;
    }
}