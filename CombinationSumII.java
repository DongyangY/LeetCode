public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        combinationSum2(candidates, target, r, l, 0);
        HashSet<List<Integer>> h = new HashSet<List<Integer>>(r);
        r.clear();
        r.addAll(h);
        return r;
    }
    
    public void combinationSum2(int[] c, int t, List<List<Integer>> r, List<Integer> l, int s) {
        if (t < 0) return;
        if (t == 0) {
            r.add(new ArrayList(l));
            return;
        }
        for (int i = s; i < c.length; i++) {
            l.add(c[i]);
            combinationSum2(c, t - c[i], r, l, i + 1);
            l.remove(l.size() - 1);
        }
    }
}