/**
 * A(n) : number of ways to paint 1, 2, 3, ..., n
 * if (color[n - 1] == color[n - 2])
 *   A(n) = A(n - 1) * (k - 1)
 * else
 *   A(n) = A(n - 1) * k
 * 
 * A1(n) : color[n] == color[n - 1]
 * A2(n) : color[n] != color[n - 1]
 * 
 * A1(n) = A2(n - 1) * 1
 * A2(n) = A1(n - 1) * (k - 1) + A2(n - 1) * (k - 1)
 * 
 * A1(1) = 0
 * A2(1) = k
 * 
 * A1(2) = k
 * A2(2) = k * (k - 1)
 * 
 * A(2) = A1(2) + A2(2) = k * k
 *
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) return 0;
        
        int[] A1 = new int[n + 1];
        int[] A2 = new int[n + 1];
        
        A1[1] = 0;
        A2[1] = k;
        
        for (int i = 2; i <= n; i++) {
            A1[i] = A2[i - 1] * 1;
            A2[i] = A1[i - 1] * (k - 1) + A2[i - 1] * (k - 1);
        }
        
        return A1[n] + A2[n];
    }
}