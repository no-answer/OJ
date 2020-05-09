package LeetCode;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 整体思路：贪心，排序之后遍历数组，接上能接上的区间
 */

public class _56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        // 这里对二维数组进行了排序，有待学习好吧
        Stack<int[]> s = new Stack<int[]>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1])
                temp[1] = Math.max(intervals[i][1], temp[1]);
            else {
                s.push(temp);
                temp = intervals[i];
            }
            if (i == intervals.length-1)
                s.push(temp);
        }
        return s.toArray(new int[s.size()][]);
    }

    public void run() {
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int N[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            N[i][0] = in.nextInt();
            N[i][1] = in.nextInt();
        }
        N = merge(N);
        for (int i = 0; i < N.length; i++)
            System.out.println(Arrays.toString(N[i]));
    }
}
