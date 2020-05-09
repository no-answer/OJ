package LeetCode;

import java.util.Scanner;

public class _45 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int N[] = new int [n];
            for (int i = 0; i < n; i++)
                N[i] = in.nextInt();
            System.out.println(jump(N));
        }
    }
}
