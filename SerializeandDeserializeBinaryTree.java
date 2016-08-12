/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode top = q.remove();
            if (top == null) {
                sb.append("null");
                sb.append(",");
                continue;
            }
            sb.append(String.valueOf(top.val));
            sb.append(",");
            q.add(top.left);
            q.add(top.right);
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);
    }
    
    private TreeNode build(String[] arr, int k) {
        if (k >= arr.length) {
            return null;
        }
        return arr[k].equals("null") ? null : new TreeNode(Integer.parseInt(arr[k]));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int i = 0;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = build(arr, i);
        if (root != null) q.add(root);
        
        while (!q.isEmpty() && i < arr.length) {
            TreeNode n = q.remove();
            TreeNode left = build(arr, i + 1);
            TreeNode right = build(arr, i + 2);
            if (left != null) {
                n.left = left;
                q.add(left);
            }
            if (right != null) {
                n.right = right;
                q.add(right);
            }
            i += 2;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));