public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutionLists = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // remove duplicates, because numbers are sorted
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int small = i + 1;
            int large = nums.length - 1;
            
            // the numbers are sorted
            while (small < large) {
                int sum = nums[i] + nums[small] + nums[large];
                
                if (sum > 0) large--;
                else if (sum < 0) small++;
                else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(new Integer(nums[i]));
                    list.add(new Integer(nums[small++]));
                    list.add(new Integer(nums[large--]));
                    solutionLists.add(list);
                
                    // remove duplicates, because numbers are sorted
                    while (small < large && nums[small] == nums[small - 1]) small++;
                    while (small < large && nums[large] == nums[large + 1]) large--;
                }
            }
            
        }
        return solutionLists;
    }
}