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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) return result;
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        
        List<Integer> level = new ArrayList<Integer>();
        
        q1.add(root);
        
        while (!q1.isEmpty()) {
            TreeNode node = q1.remove();
            level.add(node.val);
            
            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);
            
            if (q1.isEmpty()) {
                result.add(level);
                level = new ArrayList<Integer>();
                Queue<TreeNode> temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }
        
        List<List<Integer>> reversed_result = new ArrayList<List<Integer>>();
        
        for (int i = result.size() - 1; i >= 0; i--) {
            reversed_result.add(result.get(i));
        }
        
        return reversed_result;
    }
}