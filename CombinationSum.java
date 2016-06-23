public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<>();
        combinationSum(candidates, target, r, l, 0);
        return r;
    }
    
    public void combinationSum(int[] c, int t, List<List<Integer>> r, List<Integer> l, int s) {
        if (t < 0) return;
        if (t == 0) {
            r.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i = s; i < c.length; i++) {
            if (i > 0 && c[i] == c[i - 1]) continue;
            l.add(c[i]);
            combinationSum(c, t - c[i], r, l, i);
            l.remove(l.size() - 1);
        }
    }
}