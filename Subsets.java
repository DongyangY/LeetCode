public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int len = sets.size();
            for (int j = 0; j < len; j++) {
                List<Integer> set = new ArrayList<>(sets.get(j));
                set.add(nums[i]);
                sets.add(set);
            }
        }
        return sets;
    }
}