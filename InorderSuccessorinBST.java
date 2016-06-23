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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        
        if (p.right != null) {
            TreeNode leftMost = p.right;
            while (leftMost.left != null) {
                leftMost = leftMost.left;
            }
            return leftMost;
        }
        
        TreeNode parent = null;
        while (root != null) {
            if (root.val > p.val) {
                parent = root;
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                break;
            }
        }
        
        return parent;
    }
}