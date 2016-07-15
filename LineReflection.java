public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) return true;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                Set<Integer> s = new HashSet<>();
                s.add(p[1]);
                map.put(p[0], s);
            } else {
                map.get(p[0]).add(p[1]);
            }
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
        }
        
        double mid = min + (max - min) / 2.0;
        
        for (int[] p : points) {
            int x = (int)(2 * mid - p[0]);
            if (!map.containsKey(x) || !map.get(x).contains(p[1])) {
                return false;
            }
        }
        
        return true;
    }
}