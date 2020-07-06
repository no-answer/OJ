package LeetCode;

public class _32 {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int[] dp = new int [s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(' && i >= 2)
                    dp[i] = dp[i-2]+2;
                else if (s.charAt(i-1) == '(' && i < 2)
                    dp[i] = 2;
                else if (s.charAt(i-1) == ')') {
                    if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        if (i-dp[i-1] >= 2)
                            dp[i] = dp[i-1]+dp[i-dp[i-1]-2]+2;
                        else dp[i] = dp[i-1]+2;
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
