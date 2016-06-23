public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> rs = new ArrayList<String>();
        if (n <= 0) return rs;
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("0", "0");
        map.put("1", "1");
        map.put("6", "9");
        map.put("8", "8");
        map.put("9", "6");
        
        String[] mid = {"0", "1", "8"};
        
        rs.add("");
        int k = n / 2;
        while (k-- != 0) {
            int size = rs.size();
            while (size-- != 0) {
                String base = rs.remove(0);
                for (String s : map.keySet()) {
                    rs.add(base + s);
                }
            }
        }
        
        if (n % 2 != 0) {
            int size = rs.size();
            while (size-- != 0) {
                String base = rs.remove(0);
                for (String s : mid) {
                    rs.add(base + s);
                }
            }
        }
        
        for (int j = 0; j < rs.size(); j++) {
            String s = rs.get(j);
            int start = (n % 2 == 0) ? s.length() - 1 : s.length() - 2;
            for (int i = start; i >= 0; i--) {
                String c = map.get(String.valueOf(s.charAt(i)));
                s += c;
            }
            rs.set(j, s);
        }
        
        if (n == 1) return rs;
        
        List<String> r = new ArrayList<String>();
        for (String s : rs) {
            if (s.charAt(0) != '0') {
                r.add(s);
            }
        }
        return r;
    }
}