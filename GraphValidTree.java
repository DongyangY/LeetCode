public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            map.put(i, l);
        }
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        if (!validTree(0, 0, map, visited)) {
            return false;
        }
        
        for (boolean b : visited) {
            if (!b) return false;
        }
        
        return true;
    }
    
    boolean validTree(int n, int p, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[n]) return false;
        visited[n] = true;
        List<Integer> l = map.get(n);
        for (Integer i : l) {
            if (!visited[i]) {
                if (!validTree(i, n, map, visited)) return false;
            } else {
                if (i != p) return false;
            }
        }
        return true;
    }
}