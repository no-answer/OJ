package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class w_198_3 {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> list = new LinkedList<>();
        int[][] mark = new int [26][2];
        for (int i = 0; i < 26; i++) {
            mark[i] = new int[2];
            mark[i][0] = Integer.MAX_VALUE;
            mark[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < s.length(); i++) {
            int[] markI = mark[s.charAt(i) - 'a'];
            markI[0] = Math.min(i, markI[0]);
            markI[1] = Math.max(i, markI[1]);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {

        }
        return list;
    }
}
