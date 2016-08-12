public class Solution {
    class Node {
        String word;
        int dist;
        public Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
    
    // bfs for shortest path
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord, 1));
        wordList.add(endWord);
        
        while (!q.isEmpty()) {
            Node top = q.remove();
            
            if (top.word.equals(endWord)) {
                return top.dist;
            }
            
            // the set could be very large, so we try all possible transforms
            // instead of going through each word in the set and comparing
            char[] charArray = top.word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (charArray[i] != c) {
                        char t = charArray[i];
                        charArray[i] = c;
                        String trans = new String(charArray);
                        charArray[i] = t;
                        if (wordList.contains(trans)) {
                            wordList.remove(trans);
                            q.add(new Node(trans, top.dist + 1));
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}