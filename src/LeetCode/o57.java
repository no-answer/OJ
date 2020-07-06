package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class o57 {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 1;
        List<int[]> list = new ArrayList<>();
        while (i <= target/2) {
            if (sum == target) {
                int[] arr = new int [j-i+1];
                for (int k = i; k <= j; k++)
                    arr[k-i] = k;
                list.add(arr);
                sum -= i;
                i++;
            }
            else if (sum < target) {
                j++;
                sum += j;
            }
            else if (sum > target) {
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
