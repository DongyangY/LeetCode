public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] pair = new int[2];
        int index1 = 0, index2 = numbers.length - 1;
        
        while (index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if (sum < target) index1++;
            else if (sum > target) index2--;
            else break;
        }
        
        pair[0] = index1 + 1;
        pair[1] = index2 + 1;
        
        return pair;
    }
}