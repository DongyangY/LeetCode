public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            map.put(i, l);
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer l : leaves) {
                n--;
                Integer nb = map.get(l).get(0);
                map.remove(l);
                map.get(nb).remove(l);
                if (map.get(nb).size() == 1) {
                    newLeaves.add(nb);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
        
    }
}