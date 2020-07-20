package LeetCode;

import java.util.Arrays;

public class w_196_1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 2)
            return true;
        Arrays.sort(arr);
        int x = arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]-arr[i-1] != x)
                return false;
        }
        return true;
    }
}
