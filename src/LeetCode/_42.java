package LeetCode;

import java.util.Scanner;

public class _42 {
    public int trap(int [] height) {
        if (height.length == 0)
            return 0;
        int left[] = new int [height.length];
        int right[] = new int [height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }
        for (int i = height.length-2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left[i], right[i])-height[i];
        }
        return ans;
    }

    public void run () {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int N[] = new int [n];
        for (int i = 0; i < n; i++)
            N[i] = in.nextInt();
        System.out.println(trap(N));
        in.close();
    }
}
