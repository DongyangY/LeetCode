/*
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    1 5 10 10 5 1
    1 6 15 20 15 6 1
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (numRows == 0) return result;
        
        for (int i = 1; i <= numRows; i++) {
            List<Integer> line = new ArrayList<Integer>();
            line.add(1);
            
            if (i == 1) {
                result.add(line);
                continue;
            }

            int f = 0, s = 1;
            List<Integer> last_line = result.get(result.size() - 1);
            while (s < last_line.size()) {
                int f_v = last_line.get(f++);
                int s_v = last_line.get(s++);
                line.add(f_v + s_v);
            }
            
            line.add(1);
            result.add(line);
        }
        
        return result;
    }
}