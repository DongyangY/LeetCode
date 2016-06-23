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
    class Subtree {
        boolean isBST;
        int min;
        int max;
        int size;
        public Subtree(boolean isBST, int min, int max, int size) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        Subtree sub = largestBSTSubtreeHelper(root);
        return (sub == null) ? 0 : sub.size;
    }
    
    public Subtree largestBSTSubtreeHelper(TreeNode node) {
        if (node == null) return null;
        
        Subtree left = largestBSTSubtreeHelper(node.left);
        Subtree right = largestBSTSubtreeHelper(node.right);
        
        boolean isBST = false;
        if ((left == null || (left.isBST && node.val > left.max)) && 
            (right == null || (right.isBST && node.val < right.min))) {
            isBST = true;
        }
        
        int min = (left == null) ? node.val : left.min;
        int max = (right == null) ? node.val : right.max;
        
        int leftSize = (left == null) ? 0 : left.size;
        int rightSize = (right == null) ? 0 : right.size;
        int size = isBST ? leftSize + rightSize + 1 : Math.max(leftSize, rightSize);
        
        return new Subtree(isBST, min, max, size);
    }
}