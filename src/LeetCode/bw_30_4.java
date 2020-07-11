package LeetCode;

public class bw_30_4 {
    public boolean winnerSquareGame(int n) {
        boolean[] N = new boolean [100005];
        for (int i = 0; i < 100005; i++)
            N[i] = false;
        int[] M = new int [400];
        for (int i = 1; i <= 100; i++)
            M[i] = i*i;
        for (int i = 1; i < 100005; i++) {
            for (int j = 1; M[j] <= i; j++) {
                if (N[i-M[j]] == false) {
                    N[i] = true;
                    break;
                }
            }
        }
        return N[n];
    }
}
