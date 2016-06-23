public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;
        int prev = 0;
        String range = "" + nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1] + 1) continue;
            if (i - prev > 1) range += "->" + nums[i - 1];
            ranges.add(range);
            range = "" + nums[i];
            prev = i;
        }
        if (prev != nums.length - 1) range += "->" + nums[nums.length - 1];
        ranges.add(range);
        return ranges;
    }
}