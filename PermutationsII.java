public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> sets = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteUnique(nums, visited, tmp, sets);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : sets) res.add(l);
        return res;
    }
    
    public void permuteUnique(int[] nums, boolean[] visited, 
        List<Integer> tmp, Set<List<Integer>> sets) {
        if (tmp.size() >= nums.length) {
            sets.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                permuteUnique(nums, visited, tmp, sets);
            
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}