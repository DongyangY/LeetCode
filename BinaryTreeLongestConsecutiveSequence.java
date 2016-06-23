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
    public int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, null, 0);
    }
    
    private int longestConsecutive(TreeNode n, TreeNode p, int len) {
        if (n == null) return len;
        len = (p != null && n.val == p.val + 1) ? len + 1 : 1;
        return Math.max(len, Math.max(longestConsecutive(n.left, n, len), 
            longestConsecutive(n.right, n, len)));
    }
}