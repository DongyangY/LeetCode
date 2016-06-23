/*
    t = m[0 + i][0 + j]
    m[0 + i][0 + j] = m[n - 1 - j][0 + i]
    m[n - 1 - j][0 + i] = m[n - 1 - i][n - 1 - j]
    m[n - 1 - i][n - 1 - j] = m[0 + j][n - 1 - i]
    m[0 + j][n - 1 - i] = t
    
    j = i to n - 2 - i
    i++ to n / 2 - 1
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, i = 0;
        while (i < n / 2) {
            for (int j = i; j <= n - 2 - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t;
            }
            i++;
        }
    }
}