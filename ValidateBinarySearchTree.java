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
    
    // O(N) time, O(N) space
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    
    public boolean valid(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        return (low == null || node.val > low) &&
               (high == null || node.val < high) &&
               valid(node.left, low, node.val) &&
               valid(node.right, node.val, high);
    }
}
