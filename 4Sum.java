public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        //HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int small = j + 1;
                int large = nums.length - 1;
                
                while (small < large) {
                    int sum = nums[i] + nums[j] + nums[small] + nums[large];
                    
                    if (sum > target) large--;
                    else if (sum < target) small++;
                    else {
                        List<Integer> solution = new ArrayList<Integer>();
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[small++]);
                        solution.add(nums[large--]);
                        
                        //if (!hs.contains(solution)) {
                        if (!result.contains(solution)) {
                            //hs.add(solution);
                            result.add(solution);
                        }
                    }
                }
            }
        }
        
        return result;
    }
}