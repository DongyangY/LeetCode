public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int r = n, c = n, num = 0;
        int row = 0, col = -1;
        while (true) {
            for (int i = 0; i < c; i++) {
                mat[row][++col] = ++num;
            }
            if (--r <= 0) break;
            for (int i = 0; i < r; i++) {
                mat[++row][col] = ++num;
            }
            if (--c <= 0) break;
            for (int i = 0; i < c; i++) {
                mat[row][--col] = ++num;
            }
            if (--r <= 0) break;
            for (int i = 0; i < r; i++) {
                mat[--row][col] = ++num;
            }
            if (--c <= 0) break;
        }        
        return mat;
    }
}