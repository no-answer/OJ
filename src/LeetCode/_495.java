package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class _495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        Arrays.sort(timeSeries);
        int count = 0;
        int last = timeSeries[0];
        for (int i = 0; i < timeSeries.length; i++) {
            count += Math.min(timeSeries[i]-last, duration);
            last = timeSeries[i];
        }
        return count+duration;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int N[] = new int [n];
        for (int i = 0; i < n; i++)
            N[i] = in.nextInt();
        int duration = in.nextInt();
        System.out.println(findPoisonedDuration(N, duration));
    }
}
