public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // min sum from node i in every level
        int[] memo = new int[triangle.size() + 1];
        for (int j = triangle.size() - 1; j >= 0; j--) {
            for (int i = 0; i < triangle.get(j).size(); i++) {
                memo[i] = triangle.get(j).get(i) + Math.min(memo[i], memo[i + 1]);
            }
        }
        return memo[0];
    }
}