/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // Eliminate
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (knows(c, i)) c = i;
        }
        // Verify
        for (int i = 0; i < n; i++) {
            if(i != c && (knows(c, i) || !knows(i, c))) 
                return -1;
        }
        return c;
    }
}