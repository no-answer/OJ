package LeetCode;

import java.util.Scanner;

public class _97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length())
            return false;
        boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];
        matrix[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0)
                    matrix[i][j] = matrix[i][j] || (matrix[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                if (j > 0)
                    matrix[i][j] = matrix[i][j] || (matrix[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    public void run() {
        Scanner javaIn = new Scanner(System.in);
        while (true) {
            String s1 = javaIn.next();
            String s2 = javaIn.next();
            String s3 = javaIn.next();
            System.out.println(isInterleave(s1, s2, s3));
        }
    }
}
