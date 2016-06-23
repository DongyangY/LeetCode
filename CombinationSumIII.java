public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        combinationSum3(k, n, r, l, 1);
        return r;
    }
    
    public void combinationSum3(int k, int n, List<List<Integer>> r, List<Integer> l, int s) {
        if (n == 0 && k == 0) {
            r.add(new ArrayList<Integer>(l));
            return;
        }
        if (n < 0 || k <= 0) return;
        for (int i = s; i <= 9; i++) {
            l.add(i);
            combinationSum3(k - 1, n - i, r, l, i + 1);
            l.remove(l.size() - 1);
        }
    }
}