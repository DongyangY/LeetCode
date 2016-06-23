public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> uglys = new ArrayList<>();
        uglys.add(1);
        
        int k = primes.length;
        int[] offs = new int[k];
        
        while (uglys.size() < n) {
            int last = uglys.get(uglys.size() - 1);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                while (uglys.get(offs[i]) * primes[i] <= last) offs[i]++;
                int t = uglys.get(offs[i]) * primes[i];
                min = t < min ? t : min;
            }
            uglys.add(min);
        }
        
        return uglys.get(n - 1);
    }
}