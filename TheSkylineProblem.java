public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }
        
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[] {b[0], b[2]});
            height.add(new int[] {b[1], -b[2]});
        }
        
        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        pq.offer(0);
        
        int max = 0;
        for (int[] h : height) {
            if (h[1] > 0) {
                pq.offer(h[1]);
            } else {
                pq.remove(-h[1]);
            }
            
            int top = pq.peek();
            if (max != top) {
                result.add(new int[] {h[0], top});
                max = top;
            }
        }
        
        return result;
    }
}