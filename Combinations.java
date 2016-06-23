public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sets = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        combine(n, k, 1, tmp, sets);
        return sets;
    }
    
    public void combine(int n, int k, int start, 
        List<Integer> tmp, List<List<Integer>> sets) {
        if (tmp.size() == k) {
            sets.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            combine(n, k, i + 1, tmp, sets);
            tmp.remove(tmp.size() - 1);
        }
        
        return;
    }
}