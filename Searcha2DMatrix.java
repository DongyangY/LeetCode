public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        
        int l = 0, r = m;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) l = mid + 1;
            else r = mid - 1;
        }
        
        int row = r;
        if (row < 0 || row > m) return false;
        
        l = 0; 
        r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        
        return false;
    }
}