package LeetCode;

import java.util.Scanner;

public class o14 {
    int mod = 1000000007;
    public int cuttingRope(int n) {
        if (n <= 3)
            return n-1;
        int a = n/3, b = n%3;
        if (b == 0)
            return POW(3, a, 1);
        else if (b == 1)
            return POW(3, a-1, 4);
        else return POW(3, a, 2);
    }

    private int POW(int x, int a, int b) {
        long sum = 1;
        for (int i = 0; i < a; i++) {
            sum *= x;
            sum %= mod;
        }
        sum *= b;
        sum %= mod;
        return (int)sum;
    }

    public void run() {
        Scanner javaIn = new Scanner(System.in);
        int n = javaIn.nextInt();
        System.out.println(cuttingRope(n));
    }
}
