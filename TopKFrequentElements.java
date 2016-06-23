public class Solution {
    
    class Pair implements Comparable<Pair> {
        int num;
        int count;
        
        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
        
        @Override
        public int compareTo(Pair p) {
            return this.count - p.count;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (queue.size() > 0) {
            res.add(queue.poll().num);
        }
        
        Collections.reverse(res);
        
        return res;
    }
}