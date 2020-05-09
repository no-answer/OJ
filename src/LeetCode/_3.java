package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class _3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> h = new HashMap<Character, Integer>();
            for (int j = i; j < s.length(); j++) {
                if (!h.containsKey(s.charAt(j))) {
                    temp++;
                    h.put(s.charAt(j), 1);
                }
                else {
                    ans = Math.max(ans, temp);
                    temp = 0;
                    break;
                }
            }
            ans = Math.max(ans, temp);
            temp = 0;
        }
        return ans;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(lengthOfLongestSubstring(s));
        }
    }
}