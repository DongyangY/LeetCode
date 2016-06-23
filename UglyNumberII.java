public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        
        int p2 = 0, p3 = 0, p5 = 0;
        while (uglyNumbers.size() < n) {
            int last = uglyNumbers.get(uglyNumbers.size() - 1);
            while (uglyNumbers.get(p2) * 2 <= last) p2++;
            while (uglyNumbers.get(p3) * 3 <= last) p3++;
            while (uglyNumbers.get(p5) * 5 <= last) p5++;
            int next = Math.min(uglyNumbers.get(p2) * 2, uglyNumbers.get(p3) * 3);
            next = Math.min(next, uglyNumbers.get(p5) * 5);
            uglyNumbers.add(next);
        }
        
        return uglyNumbers.get(n - 1);
    }
}