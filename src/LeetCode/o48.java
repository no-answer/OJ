package LeetCode;

import java.util.HashMap;

public class o48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int[] mark = new int [s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                mark[i] = s.length()+1;
                hashMap.put(s.charAt(i), i);
            }
            else {
                mark[i] = i-hashMap.get(s.charAt(i));
                hashMap.replace(s.charAt(i), i);
            }
        }
        int[] dp = new int [s.length()];
        dp[0] = 1;
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = Math.min(dp[i-1]+1, mark[i]);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
