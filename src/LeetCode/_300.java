package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class _300 {
    public int lengthOfLIS(int [] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] low = new int [nums.length+1];
        int count = 1;
        Arrays.fill(low, Integer.MAX_VALUE);
        low[0] = Integer.MIN_VALUE;
        low[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= count; j++)
                if (nums[i] > low[j-1] && nums[i] < low[j])
                    low[j] = nums[i];
            if (nums[i] > low[count]) {
                count++;
                low[count] = nums[i];
            }
        }
        return count;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int [n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        System.out.println(lengthOfLIS(nums));
        in.close();
    }
}
