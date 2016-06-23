/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        
        map.put(node, nodeCopy);
        q.add(node);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.remove();
            
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(n).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.get(n).neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    q.add(neighbor);
                }
            }
        }
        
        return nodeCopy;
    }
}