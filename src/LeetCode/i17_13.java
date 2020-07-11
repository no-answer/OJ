package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class i17_13 {
    public int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++)
            dic.add(dictionary[i]);
        int[] dp = new int [sentence.length()+1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i-1]+1;
            for (int j = 0; j < i; j++) {
                if (dic.contains(sentence.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[sentence.length()];
    }
}
