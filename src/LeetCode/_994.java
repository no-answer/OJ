package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _994 {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> q = new LinkedList<Integer>();
        int nice = 0;
        int now = 0, next = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                    now++;
                }
                else if (grid[i][j] == 1)
                    nice++;
            }
        }
        int time = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            if (x > 0 && grid[x-1][y] == 1) {
                grid[x-1][y] = 2;
                next++;
                nice--;
                q.add(x-1);
                q.add(y);
            }
            if (x < grid.length-1 && grid[x+1][y] == 1) {
                grid[x+1][y] = 2;
                next++;
                nice--;
                q.add(x+1);
                q.add(y);
            }
            if (y > 0 && grid[x][y-1] == 1){
                grid[x][y-1] = 2;
                next++;
                nice--;
                q.add(x);
                q.add(y-1);
            }
            if (y < grid[x].length-1 && grid[x][y+1] == 1) {
                grid[x][y+1] = 2;
                next++;
                nice--;
                q.add(x);
                q.add(y+1);
            }
            now--;
            if (now == 0) {
                now = next;
                next = 0;
                time++;
            }
        }
        if (time == 0) time++;
        return nice > 0 ? -1 : time-1;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int [n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(orangesRotting(grid));
    }
}
