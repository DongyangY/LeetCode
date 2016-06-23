public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length, l = A[0].length;
        int[][] r = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < l; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    r[i][j] += A[i][k] * B[k][j];    
                }
            }
        }
        return r;
    }
}