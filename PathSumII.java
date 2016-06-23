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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        pathSum(root, sum - root.val, temp, result);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> temp, 
        List<List<Integer>> result) {
        if (root.left == null && root.right == null && sum == 0) {
            List<Integer> t = new ArrayList<>(temp);
            result.add(t);
            return;
        }
        
        if (root.left != null) {
            temp.add(root.left.val);
            pathSum(root.left, sum - root.left.val, temp, result);
            
            temp.remove(temp.size() - 1);
        }
        
        if (root.right != null) {
            temp.add(root.right.val);
            pathSum(root.right, sum - root.right.val, temp, result);
            
            temp.remove(temp.size() - 1);
        }
    }
}