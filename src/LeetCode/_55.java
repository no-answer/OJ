package LeetCode;

import java.util.Scanner;

public class _55 {
    public boolean canJump(int[] nums) {
        boolean b[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
            b[i] = false;
        b[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (b[i]) {
                for (int j = 1; j <= nums[i] && i+j < nums.length; j++)
                    b[i+j] = true;
            }
        }
        return b[nums.length-1];
    }

    public void run() {
        Scanner in = new Scanner((System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int N[] = new int[n];
            for (int i = 0; i < n; i++)
                N[i] = in.nextInt();
            System.out.println(canJump(N));
        }
    }
}
