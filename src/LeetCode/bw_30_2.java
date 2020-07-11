package LeetCode;

import java.util.Arrays;

public class bw_30_2 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int[] sum = new int [4];
        sum[0] = nums[nums.length-1]-nums[3];
        sum[1] = nums[nums.length-2]-nums[2];
        sum[2] = nums[nums.length-3]-nums[1];
        sum[3] = nums[nums.length-4]-nums[0];
        Arrays.sort(sum);
        return sum[0];
    }
}
