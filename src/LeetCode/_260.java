package LeetCode;

import java.util.Scanner;

public class _260 {
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for(int a : nums)
            n ^= a;
        int mark = 1;
        while((n & mark) == 0)
            mark <<= 1;
        int x1 = 0;
        int x2 = 0;
        for(int a : nums)
            if((a & mark) == 0)
                x1 ^= a;
            else
                x2 ^= a;
        return new int[] {x1, x2};
    }

    public void run() {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int N[] = new int [n];
        for(int i = 0; i < n; i++)
            N[i] = in.nextInt();
        N = singleNumbers(N);
        for (int x : N)
            System.out.print(x + " ");
    }
}
