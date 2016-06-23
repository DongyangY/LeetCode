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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode p = new TreeNode(preorder[preStart]);
        
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == p.val) {
                k = i;
                break;
            }
        }
        
        p.left = construct(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k - 1);
        p.right = construct(preorder, preStart + k - inStart + 1, preEnd, inorder, k + 1, inEnd);
        
        return p;
    }
}