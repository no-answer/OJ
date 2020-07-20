package LeetCode;

import java.util.Arrays;

public class o29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int [0];
        boolean[][] mark = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < mark.length; i++)
            Arrays.fill(mark[i], false);
        int x = 0, y = 0, direction = 0;
        int[] C = new int [mark.length*mark[0].length];
        int count = 0;
        while (x >= 0 && x < mark.length && y >= 0 && y < mark[0].length && !mark[x][y]) {
            C[count] = matrix[x][y];
            mark[x][y] = true;
            count++;
            if (direction == 0) {
                if (y+1 == mark[0].length || mark[x][y+1]) {
                    direction = 1;
                    x++;
                }
                else y++;
            }
            else if (direction == 1) {
                if (x+1 == mark.length || mark[x+1][y]) {
                    direction = 2;
                    y--;
                }
                else x++;
            }
            else if (direction == 2) {
                if (y-1 < 0 || mark[x][y-1]) {
                    direction = 3;
                    x--;
                }
                else y--;
            }
            else if (direction == 3) {
                if (x-1 < 0 || mark[x-1][y]) {
                    direction = 0;
                    y++;
                }
                else x--;
            }
        }
        return C;
    }
}
