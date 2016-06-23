public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = 10;
        List<String> r = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <= s.length() - l; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                int freq =  map.get(sub);
                if (freq == 1) r.add(sub);
                map.put(sub, freq + 1);
            } else {
                map.put(sub, 1);
            }
        }
        return r;
    }
}