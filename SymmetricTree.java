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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        if (!add(root.left, root.right, stack)) return false;
        
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left.val != right.val) return false;
            if (!add(left.right, right.left, stack)) return false;
            if (!add(left.left, right.right, stack)) return false;
        }
        
        return true;
    }
    
    private boolean add(TreeNode left, TreeNode right, Stack<TreeNode> stack) {
        if (left == null && right == null) return true;
        else if (left != null && right != null) {
            stack.push(left);
            stack.push(right);
            return true;
        } else {
            return false;
        }
    }
}