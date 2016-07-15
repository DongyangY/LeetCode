public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        LinkedList<int[]> result = new LinkedList<>();
        
        int m = Math.min(nums1.length, k);
        int n = Math.min(nums2.length, k);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(1, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] + o2[1] - o1[0] - o1[1];
            }    
        });
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k) {
                    pq.offer(new int[] {nums1[i], nums2[j]});
                } else {
                    int[] top = pq.peek();
                    int sum = nums1[i] + nums2[j];
                    if (sum < top[0] + top[1]) {
                        pq.poll();
                        pq.offer(new int[] {nums1[i], nums2[j]});
                    }
                }
            }
        }
        
        while (!pq.isEmpty()) {
            result.addFirst(pq.poll());
        }
        
        return result;
    }
}