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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> t = new ArrayList<>();
        pathSum(root, sum, t, res);
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> t, List<List<Integer>> res) {
        t.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                res.add(new ArrayList<Integer>(t));
                return;
            }
        }
        
        if (root.left != null) {
            pathSum(root.left, sum - root.val, t, res);
            t.remove(t.size() - 1);
        }
        
        if (root.right != null) {
            pathSum(root.right, sum - root.val, t, res);
            t.remove(t.size() - 1);
        }
    }
}