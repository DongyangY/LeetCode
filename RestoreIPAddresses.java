public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> sets = new ArrayList<>(); 
        List<String> tmp = new ArrayList<>();
        restoreIpAddresses(s, 0, tmp, sets);
        
        List<String> ret = new ArrayList<>();
        for (List<String> set : sets) {
            StringBuilder sb = new StringBuilder();
            for (String str : set) {
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
        }
        
        return ret;
    }
    
    public void restoreIpAddresses(String s, int start, 
        List<String> tmp, List<List<String>> sets) {
        
        if (tmp.size() == 4) {
            if (start == s.length())
                sets.add(new ArrayList<String>(tmp));
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) return;
            String part = s.substring(start, start + i);
            if (Integer.parseInt(part) > 255) return;
            if (i > 1 && s.charAt(start) == '0') return;
            tmp.add(part);
            restoreIpAddresses(s, start + i, tmp, sets);
            tmp.remove(tmp.size() - 1);
        }
    }
}