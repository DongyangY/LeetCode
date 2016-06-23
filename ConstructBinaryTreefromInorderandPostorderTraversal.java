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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode construct(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        TreeNode p = new TreeNode(postorder[pEnd]);
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == p.val) {
                k = i;
                break;
            }
        }
        p.left = construct(postorder, pStart, pStart + k - iStart - 1, inorder, iStart, k - 1);
        p.right = construct(postorder, pStart + k - iStart, pEnd - 1, inorder, k + 1, iEnd);
        return p;
    }
}