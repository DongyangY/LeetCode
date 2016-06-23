public class WordDistance {
    HashMap<String, List<Integer>> m = new HashMap<String, List<Integer>>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if(m.containsKey(words[i])) {
                m.get(words[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                m.put(words[i], l);
            }    
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = m.get(word1);
        List<Integer> l2 = m.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i1 : l1) {
            for (int i2 : l2) {
                min = Math.min(min, Math.abs(i1 - i2));
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");