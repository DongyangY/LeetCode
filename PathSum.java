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
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }
    
    public boolean hasPathSum(TreeNode node, int sum, int target) {
        // Null node
        if (node == null) return false;
        // Leaf node
        if (node.left == null && node.right == null) return sum + node.val == target;
        return hasPathSum(node.left, sum + node.val, target) || 
                hasPathSum(node.right, sum + node.val, target);
    }
}