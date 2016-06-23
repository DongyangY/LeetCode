public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> hs = new HashSet<>();
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<Integer>());
        hs.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int len = sets.size();
            for (int j = 0; j < len; j++) {
                List<Integer> set = new ArrayList<>(sets.get(j));
                set.add(nums[i]);
                sets.add(set);
                hs.add(set);
            }
        }
        sets.clear();
        for (List<Integer> l : hs) {
            sets.add(l);
        }
        return sets;
    }
}