public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int i = 0, j = n;
        while (i >= 0 && i <= m && j >= 0 && j <= n) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}