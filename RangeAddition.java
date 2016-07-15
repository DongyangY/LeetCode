public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] u : updates) {
            if (u[0] - 1 >= 0) {
                result[u[0] - 1] -= u[2];
            }
            result[u[1]] += u[2];
        }
        
        for (int i = result.length - 2; i >= 0; i--) {
            result[i] += result[i + 1];
        }
        
        return result;
    }
}