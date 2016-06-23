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
    private TreeNode nr;
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return upsideDownBinaryTree(root, null);
    }
    
    public TreeNode upsideDownBinaryTree(TreeNode p, TreeNode parent) {
        if (p == null) return parent;
        TreeNode root = upsideDownBinaryTree(p.left, p);
        // For the original root's parent == null
        p.left = parent == null ? null : parent.right;
        p.right = parent;
        return root;
    }
}