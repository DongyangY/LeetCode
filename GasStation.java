public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int index = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            sum += remain;
            total += remain;
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
        }
        
        if (total >= 0) return index;
        else return -1;
    }
}