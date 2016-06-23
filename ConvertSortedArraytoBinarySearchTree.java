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
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0, r = nums.length - 1;
        return binaryScan(nums, l, r);
    }
    
    public TreeNode binaryScan(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = binaryScan(nums, l, mid - 1);
        node.right = binaryScan(nums, mid + 1, r);
        return node;
    }
}