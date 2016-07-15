public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("_");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            char c = s.charAt(j);
            while (j < s.length() && c != '_') {
                c = s.charAt(++j);
            }
            int len = Integer.parseInt(s.substring(i, j));
            list.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));