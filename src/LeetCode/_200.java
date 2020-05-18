package LeetCode;

import java.util.Scanner;

public class _200 {

    int[] set;

    int find(int index) {
        return set[index];
    }

    void union(int index1, int index2) {
        index1 = find(index1);
        index2 = find(index2);
        while (set[index2] != index2) {
            int temp = index2;
            index2 = set[index2];
            set[temp] = index1;
        }
    }

    public int numIslands(char[][] grid) {
        int size = grid.length*grid[0].length;
        set = new int [size+1];
        for (int i = 0; i <= size; i++)
            set[i] = i;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i > 0 && find(i*grid.length+j) != find((i-1)*grid.length)+j)
                    union((i-1)*grid.length+j, i*grid.length+j);
                if (i < grid.length-1 && find(i*grid.length+j) != find((i+1)*grid.length+j))
                    union(i*grid.length+j, (i+1)*grid.length+j);
                if (j > 0 && find(i*grid.length+j) != find(i*grid.length+j-1))
                    union(i*grid.length+j-1, i*grid.length+j);
                if (j < grid[i].length-1 && find(i*grid.length+j) != find(i*grid.length+j+1))
                    union(i*grid.length+j, (i+1)*grid.length+j+1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] == i)
                cnt++;
        }
        return cnt;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = new char [n][m];
        for (int i = 0; i < n; i++) {
            String temp = in.next();
            grid[i] = temp.toCharArray();
        }
        System.out.println(numIslands(grid));
        in.close();
    }
}
