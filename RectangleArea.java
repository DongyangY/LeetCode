public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (C - A) * (D - B);
        int a2 = (G - E) * (H - F);
        if (E > C || A > G || F > D || B > H) return a1 + a2;
        else return a1 - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F)) + a2;
    }
}