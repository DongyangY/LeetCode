public class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[256];
        int bull = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) ++bull;
            else {
                if (map[s]++ < 0) ++cows;
                if (map[g]-- > 0) ++cows;
            }
        }
        return bull + "A" + cows + "B";
    }
}