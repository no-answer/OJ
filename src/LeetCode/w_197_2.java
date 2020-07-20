package LeetCode;

public class w_197_2 {
    public int numSub(String s) {
        int[] dp = new int [s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && (i == 0 || s.charAt(i-1) == '0'))
                dp[i] = 1;
            else if (s.charAt(i) == '1' && s.charAt(i-1) == '1')
                dp[i] = dp[i-1]+1;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += dp[i];
            count %= 1000000007;
        }
        return count;
    }
}
