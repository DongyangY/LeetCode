public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = String.valueOf(c);
            if (map.containsKey(k)) {
                map.get(k).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(k, l);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : map.values()) {
            Collections.sort(l);
            res.add(l);
        }
        return res;
    }
}