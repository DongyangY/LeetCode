public class Solution {
    public int lengthOfLIS(int[] nums) {
        // binary search O(nlogn)
        if (nums == null || nums.length == 0)
            return 0;
        
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) {
            if (list.size() == 0) {
                list.add(num);
            } else if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;
                
                // the smallest bigger than num
                while (i < j) {
                    int mid = i + (j - i) / 2;
                    if (list.get(mid) >= num) {
                        j = mid;
                    } else {
                        i = mid + 1;
                    }
                }
                
                list.set(j, num);
            }
        }
        
        return list.size();
    }
}