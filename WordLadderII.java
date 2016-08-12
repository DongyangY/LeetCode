public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        wordList.add(endWord);
        wordList.remove(beginWord);
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        q1.add(beginWord);
        
        Map<String, Set<String>> path = new HashMap<>();
        
        while (!q1.isEmpty()) {
            String top = q1.remove();
            
            if (top.equals(endWord)) {
                  break;  
            }
            
            char[] charArray = top.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != charArray[i]) {
                        char t = charArray[i];
                        charArray[i] = c;
                        String s = new String(charArray);
                        if (wordList.contains(s)) {
                            q2.add(s);
                            if (path.containsKey(s)) {
                                path.get(s).add(top);
                            } else {
                                Set<String> set = new HashSet<>();
                                set.add(top);
                                path.put(s, set);
                            }
                        }
                        charArray[i] = t;
                    }
                }
            }
            
            if (q1.isEmpty()) {
                for (String s : q2) {
                    wordList.remove(s);
                }
                
                Queue<String> t = q1;
                q1 = q2;
                q2 = t;
            }
        }
        
        constructResult(result, path, beginWord, endWord, new LinkedList<String>());
        
        return result;
    }
    
    private void constructResult(List<List<String>> result, Map<String, Set<String>> path, 
        String beginWord, String endWord, LinkedList<String> temp) {
        temp.addFirst(endWord);
        
        if (endWord.equals(beginWord)) {
            result.add(new LinkedList<String>(temp));
            temp.removeFirst();
            return;
        }
        
        if (path.containsKey(endWord)) {
            Set<String> set = path.get(endWord);
            for (String s : set) {
                constructResult(result, path, beginWord, s, temp);
            }
        }
        
        temp.removeFirst();
    }
}