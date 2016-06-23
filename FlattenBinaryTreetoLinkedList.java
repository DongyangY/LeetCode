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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenRecur(root);
    }
    
    public TreeNode flattenRecur(TreeNode node) {
        TreeNode rtree = node.right;
        if (node.left != null) {
            node.right = node.left;
            node.left = null;
            // return the last node after flatten.
            node = flattenRecur(node.right);
        }
        if (rtree != null) {
            node.right = rtree;
            node = flattenRecur(node.right);
        }
        return node;
    }
}