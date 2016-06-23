public class ValidWordAbbr {
    private HashMap<String, String> abbrs = new HashMap<String, String>();
    
    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            abbrs.put(abbr, abbrs.containsKey(abbr) && 
                (abbrs.get(abbr) == null || !abbrs.get(abbr).equals(word)) ? 
                null : word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !abbrs.containsKey(abbr) || 
               (abbrs.get(abbr) != null && abbrs.get(abbr).equals(word));
    }
    
    public String getAbbr(String word) {
        return word.length() < 3 ? word : String.valueOf(word.charAt(0)) + 
                                          String.valueOf(word.length() - 2) + 
                                          String.valueOf(word.charAt(word.length() - 1));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");