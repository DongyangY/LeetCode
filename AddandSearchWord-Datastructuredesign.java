public class WordDictionary {
    
    private class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;
 
        public TrieNode() {}
 
        public TrieNode(char c){
            this.c = c;
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode t = new TrieNode(c);
                node.children.put(c, t);
                node = t;
            }
        }
        node.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    
    public boolean dfs(String word, TrieNode node, int start) {
        if (start >= word.length()) {
            return node.isLeaf;
        }
        
        char c = word.charAt(start);
        if (node.children.containsKey(c)) {
            return dfs(word, node.children.get(c), start + 1);
        } else if (c == '.') {
            boolean result = false;
            for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
                if (dfs(word, child.getValue(), start + 1)) result = true;
            }
            return result;
        } else {
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");