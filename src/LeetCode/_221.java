package LeetCode;

import javax.xml.stream.XMLInputFactory;
import java.util.Scanner;

public class _221 {
    public int maxSquare(char[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int map [][] = new int [matrix.length][matrix[0].length];
        map[0][0] = matrix[0][0] == '0' ? 0 : 1;
        int ans = map[0][0];
        for (int i = 1; i < map.length; i++) {
            map[i][0] = matrix[i][0] == '0' ? 0 : 1;
            ans = Math.max(ans, map[i][0]);
        }
        for (int i = 1; i < map[0].length; i++) {
            map[0][i] = matrix[0][i] == '0' ? 0 : 1;
            ans = Math.max(ans, map[0][i]);
        }
        for (int i = 1; i < map.length; i++)
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] = matrix[i][j] == '0' ? 0 : Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1])+1;
                ans = Math.max(ans, map[i][j]);
            }
        return ans*ans;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char N[][] = new char [n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                N[i][j] = in.next().charAt(0);
        }
        System.out.println(maxSquare(N));
    }
}
