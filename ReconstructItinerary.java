public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        LinkedList<String> result = new LinkedList<>();
        
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        dfs("JFK", map, result);
        return result;
    }
    
    public void dfs(String s, HashMap<String, PriorityQueue<String>> map, LinkedList<String> result) {
        PriorityQueue<String> q = map.get(s);
        
        // Has out-degree
        while (q != null && !q.isEmpty()) {
            // Remove the edge
            String next = q.poll();
            dfs(next, map, result);
        }
        
        // No out-degree
        result.addFirst(s);
    }
}