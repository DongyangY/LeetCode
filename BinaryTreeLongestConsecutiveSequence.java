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
    
    public int longestConsecutive(TreeNode cur, TreeNode p, int len) {
        if (cur == null) return len;
        
        if (p != null && cur.val == p.val + 1) {
            len++;
        } else {
            len = 1;
        }
        
        int left = longestConsecutive(cur.left, cur, len);
        int right = longestConsecutive(cur.right, cur, len);
        
        return Math.max(len, Math.max(left, right));
    }
}