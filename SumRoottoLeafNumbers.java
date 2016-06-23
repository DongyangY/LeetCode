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
    public int sumNumbers(TreeNode root) {
        List<String> nums = new ArrayList<>();
        sumNumbers(root, "", nums);
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
    
    public void sumNumbers(TreeNode node, String temp, List<String> nums) {
        if (node == null) return;
        
        temp += String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            nums.add(temp);
            return;
        }
        
        sumNumbers(node.left, temp, nums);
        sumNumbers(node.right, temp, nums);
    }
}