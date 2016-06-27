public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int row = 0, col = 0;
        
        while (true) {
            for (col = left; col <= right; col++) {
                result.add(matrix[row][col]);
            }
            col--;
            top++;
            if (top > bottom) break;
            
            for (row = top; row <= bottom; row++) {
                result.add(matrix[row][col]);
            }
            row--;
            right--;
            if (right < left) break;
        
            for (col = right; col >= left; col--) {
                result.add(matrix[row][col]);
            }
            col++;
            bottom--;
            if (top > bottom) break;
        
            for (row = bottom; row >= top; row--) {
                result.add(matrix[row][col]);
            }
            row++;
            left++; 
            if (right < left) break;
        }
        
        return result;
    }
}