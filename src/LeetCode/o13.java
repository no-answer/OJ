package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class o13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] matrix = new boolean[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(matrix[i], false);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(0);
        int count = 1;
        matrix[0][0] = true;
        while (!stack.isEmpty()) {
            int y = stack.pop();
            int x = stack.pop();
            count++;
            if (x > 0 && sum(x-1)+sum(y) <= k && !matrix[x-1][y]) {
                stack.push(x-1);
                stack.push(y);
                matrix[x-1][y] = true;
            }
            if (y > 0 && sum(x)+sum(y-1) <= k && !matrix[x][y-1]) {
                stack.push(x);
                stack.push(y-1);
                matrix[x][y-1] = true;
            }
            if (x < m-1 && sum(x+1)+sum(y) <= k && !matrix[x+1][y]) {
                stack.push(x+1);
                stack.push(y);
                matrix[x+1][y] = true;
            }
            if (y < n-1 && sum(x)+sum(y+1) <= k && !matrix[x][y+1]) {
                stack.push(x);
                stack.push(y+1);
                matrix[x][y+1] = true;
            }
        }
        return count;
    }

    private int sum(int x) {
        int s = 0;
        while (x > 0) {
            s += x%10;
            x /= 10;
        }
        return s;
    }
}
