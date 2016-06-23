/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] helper(TreeNode node) {
        int[] memo = new int[2];
        if (node == null) {
            return memo;
        }
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        memo[0] = node.val + left[1] + right[1];
        memo[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return memo;
    }
}