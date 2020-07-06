package LeetCode;

import java.util.Scanner;

public class o65 {
    public int add(int a, int b) {
        if (b == 0)
            return a;
        return add(a^b, (a&b) << 1);
    }

    public void run() {
        Scanner javain = new Scanner(System.in);
        int a = javain.nextInt();
        int b = javain.nextInt();
        System.out.println(add(a, b));
    }
}
