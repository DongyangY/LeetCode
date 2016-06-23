public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            map.put(i, l);
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                countComponents(i, map, visited);
            }
        }
        return count;
    }
    
    public void countComponents(int n, Map<Integer, List<Integer>> map, boolean[] visited) {
        visited[n] = true;
        List<Integer> l = map.get(n);
        for (Integer i : l) {
            if (!visited[i]) {
                countComponents(i, map, visited);
            }
        }
    }
}