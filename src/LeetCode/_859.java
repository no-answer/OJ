package LeetCode;

import java.util.*;

public class _859 {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.equals("") || A.length() == 1)
            return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i)))
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            else
                map.put(A.charAt(i), 1);
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                if (count > 2)
                    return false;
                list.add(i);
            }
        }

        if (count == 0) {
            int c[] = new int [26];
            for (int i = 0; i < A.length(); i++)
                c[A.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++)
                if (c[i] > 1)
                    return true;
        }
        else if (count == 1)
            return false;
        else if(A.charAt(list.get(0)) == B.charAt(list.get(1)) && A.charAt(list.get(1)) == B.charAt(list.get(0)))
            return true;
        return false;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        System.out.print(buddyStrings(A, B));
    }
}
