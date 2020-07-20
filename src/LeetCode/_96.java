package LeetCode;

public class _96 {
    public int numTrees(int n) {
        int[] N = new int [n+1];
        N[0] = 1;
        N[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                N[i] += N[j-1]*N[i-j];
            }
        }
        return N[n];
    }
}
