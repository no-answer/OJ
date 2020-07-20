package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class o10 {
    class Matrix {
        public int row;
        public int col;
        public long [][] m;

        Matrix(int r, int c) {
            row = r;
            col = c;
            m = new long [row][col];
            for (int i = 0; i < row; i++)
                Arrays.fill(m[i], 0);
        }
    }

    public Matrix MUL(Matrix a, Matrix b) {
        Matrix m = new Matrix(a.row, b.col);
        for (int i = 0; i < a.row; i++) {
            for (int j = 0; j < b.col; j++) {
                for (int k = 0; k < a.col; k++) {
                    m.m[i][j] += a.m[i][k]*b.m[k][j];
                    m.m[i][j] %= 1000000007;
                }
            }
        }
        return m;
    }

    public int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        long[][] m = {{1, 1}, {1, 0}};
        long[][] r = {{1}, {0}};
        long[][] z = {{1, 1}, {1, 1}};
        Matrix matrix = new Matrix(2, 2);
        matrix.m = m;
        Matrix M = new Matrix(2, 2);
        M.m  = z;
        Matrix root = new Matrix(2, 1);
        root.m = r;
        n -= 2;
        while (n > 0) {
            if (n%2 == 1)
                M = MUL(M, matrix);
            matrix = MUL(matrix, matrix);
            n /= 2;
        }
        return (int)MUL(root, M).m[0][0];
    }

    public void run() {
        Scanner javaIn = new Scanner(System.in);
        while (true) {
            System.out.println(fib(javaIn.nextInt()));
        }
    }
}
