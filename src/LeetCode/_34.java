package LeetCode;

import java.util.Scanner;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int [2];
        int find = binarySearch(nums, target);
        ans[0] = find;
        ans[1] = find;
        if (find == -1)
            return ans;
        while (ans[0] > 0 && nums[ans[0]-1] == target)
            ans[0]--;
        while (ans[1] < nums.length-1 && nums[ans[1]+1] == target)
            ans[1]++;
        return ans;
    }

    int binarySearch(int [] nums, int x) {
        int left = 0, right = nums.length-1, mid;
        while (left <= right) {
            if (nums[left] == x)
                return left;
            else if (nums[right] == x)
                return right;
            mid = (left+right)/2;
            if (nums[mid] == x)
                return mid;
            else if (nums[mid] < x)
                left = mid+1;
            else right = mid-1;
        }
        return -1;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n, target;
        n = in.nextInt();
        int N[] = new int [n];
        for (int i = 0; i < n; i++)
            N[i] = in.nextInt();
        target = in.nextInt();
        System.out.println(searchRange(N, target)[0]+" "+searchRange(N, target)[1]);
        //in.close();
    }
}
