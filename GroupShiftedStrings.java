public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> pattern = new HashMap<String, List<String>>();
        List<List<String>> list = new ArrayList<>();
        for (String s : strings) {
            String p = getShiftPattern(s);
            if (!pattern.containsKey(p)) {
                List<String> l = new ArrayList<>();
                pattern.put(p, l);
                list.add(l);
            }
            pattern.get(p).add(s);
        }
        for (String p : pattern.keySet()) Collections.sort(pattern.get(p));
        return list;
    }
    
    public String getShiftPattern(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((s.charAt(i) - s.charAt(0) + 26) % 26);
            sb.append(",");
        }
        return sb.toString();
    }
}