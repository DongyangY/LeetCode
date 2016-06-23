public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>();
        codes.add(0);
        for (int i = 1; i <= n; i++) {
            int shift = 1 << (i - 1);
            for (int j = codes.size() - 1; j >= 0; j--) {
                codes.add(codes.get(j) + shift);
            }
        }
        return codes;
    }
}