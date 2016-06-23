public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                result.add(new String(arr));
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }
        return result;
    }
}