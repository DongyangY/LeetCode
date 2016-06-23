public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        while (!set.contains(n)) {
            set.add(n);
            n = getNext(n);
            if (n == 1) return true;
        }
        
        return false;
    }
    
    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int mod = n % 10;
            sum += mod * mod;
            n /= 10;
        }
        return sum;
    }
}