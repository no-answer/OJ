package LeetCode;

import java.util.Scanner;
import java.util.Stack;

public class _202 {
    public boolean isHappy(int n) {
        for (int i = 0; i < 1000; i++) {
            n = op(n);
            if (n == 1)
                return true;
        }
        return false;
    }

    public int op(int n) {
        Stack<Integer> s = new Stack<Integer>();
        while (n > 0) {
            s.push(n % 10);
            n /= 10;
        }
        int ans = 0;
        while (!s.empty()) {
            ans += s.peek() * s.peek();
            s.pop();
        }
        return ans;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int temp = in.nextInt();
            System.out.println(isHappy(temp));
        }

    }
}
