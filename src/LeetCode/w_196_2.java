package LeetCode;

public class w_196_2 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int count = 0;
        for (int i = 0; i < left.length; i++)
            count = Math.max(count, left[i]);
        for (int i = 0; i < right.length; i++)
            count = Math.max(count, n-right[i]);
        return count;
    }
}
