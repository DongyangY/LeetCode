public class Solution {
    // x^n = x^(n/2) * x^(n/2) * x^(n%2)
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }
    }
    
    public double pow(double x, int n) {
        if (n == 0) return 1;
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}