public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex + 2; i++) row.add(0);
        row.set(1, 1);
        for (int i = 1; i <= rowIndex; i++) {
            int prev = 0, curr = 0;
            for (int j = 1; j <= i + 1; j++) {
                curr = row.get(j);
                row.set(j, prev + curr);
                prev = curr;
            }
        }
        row.remove(rowIndex + 2);
        row.remove(0);
        return row;
    }
}