package LeetCode;

import java.util.Scanner;

public class _53 {
    public int maxSubArray(int[] nums) {
        int sum = 0, ans = nums[0];
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int N[] = new int [n];
        for (int i = 0; i < n; i++)
            N[i] = in.nextInt();
        System.out.println(maxSubArray(N));
    }
}
