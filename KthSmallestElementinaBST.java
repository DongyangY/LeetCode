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
    class MutableInt {
        int val;
        public MutableInt(int val) {
            this.val = val;
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, k, new MutableInt(0)).val;
    }
    
    public TreeNode kthSmallest(TreeNode node, int k, MutableInt i) {
        if (node == null) return node;
        TreeNode left = kthSmallest(node.left, k, i);
        if (left != null) return left;
        
        i.val++;
        if (i.val == k) return node;
        
        TreeNode right = kthSmallest(node.right, k, i);
        return right;
    }
}