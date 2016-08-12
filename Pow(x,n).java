public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        return n > 0 ? pow(x, n) : 1 / pow(x, (long)n * -1);
    }
    
    private double pow(double x, long n) {
        if (n == 1) return x;
        double h = pow(x, n / 2);
        if (n % 2 == 0) {
            return h * h;
        } else {
            return h * h * x;
        }
    }
}