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
    private class Node {
        TreeNode node;
        int col;
        public Node(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res =  new ArrayList<>();
        
        if (root == null) return res;
        
        int min = 0, max = 0;
        q.add(new Node(root, 0));
        while (!q.isEmpty()) {
            Node n = q.remove();
            min = Math.min(min, n.col);
            max = Math.max(max, n.col);   
            if (map.containsKey(n.col)) {
                map.get(n.col).add(n.node.val);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(n.node.val);
                map.put(n.col, l);    
            } 
            if (n.node.left != null) q.add(new Node(n.node.left, n.col - 1));
            if (n.node.right != null) q.add(new Node(n.node.right, n.col + 1));
        }
        
        for (int i = min; i <= max; i++) {
            List<Integer> l = map.get(i);
            if (l != null) res.add(l);
        }
        return res;
    }
}