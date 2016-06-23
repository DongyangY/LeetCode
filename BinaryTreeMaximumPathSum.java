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
    
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    public int findMax(TreeNode p) {
        if (p == null) return 0;
        int left = findMax(p.left);
        int right = findMax(p.right);
        maxSum = Math.max(maxSum, p.val + left + right);
        int ret = p.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }
}