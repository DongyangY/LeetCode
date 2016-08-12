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
    private Map<TreeNode, Integer> map = new HashMap<>();
    
    private int getSize(TreeNode root) {
        if (root == null) return 0;
        int left = getSize(root.left);
        int right = getSize(root.right);
        int size = left + right + 1;
        map.put(root, size);
        return size;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        getSize(root);
        return getKth(root, k).val;
    }
    
    private TreeNode getKth(TreeNode root, int k) {
        int left = root.left == null ? 0 : map.get(root.left);
        if (left + 1 == k) return root;
        else if (left + 1 > k) {
            return getKth(root.left, k);
        } else {
            return getKth(root.right, k - left - 1);    
        }
    }
}