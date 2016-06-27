public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        generateAbbreviations(word, "", result);
        return result;
    }
    
    private void generateAbbreviations(String word, String temp, List<String> result) {
        if (temp.length() == word.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if (c == '0') {
                    sb.append(word.charAt(i));
                } else {
                    int cnt = 0;
                    while (i < temp.length() && temp.charAt(i) == '1') {
                        cnt++;
                        i++;
                    }
                    i--;
                    sb.append(String.valueOf(cnt));
                }
            }
            result.add(sb.toString());
            return;
        }
        
        generateAbbreviations(word, temp + "0", result);
        generateAbbreviations(word, temp + "1", result);
    }
}