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
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root) != -1;
    }
    
    public int checkBalanced(TreeNode root) {
        if (root == null) return 0;
        int l = checkBalanced(root.left);
        int r = checkBalanced(root.right);
        return (l == -1 || r == -1 || Math.abs(l - r) > 1) ? -1 : Math.max(l, r) + 1;
    }
}