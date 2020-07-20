package LeetCode;

import java.util.Arrays;

public class _785 {
    public boolean isBipartite(int[][] graph) {
        int[] N = new int [graph.length];
        Arrays.fill(N, -1);
        for (int i = 0; i < graph.length; i++) {
            if (N[i] == -1) {
                N[i] = 1;
                if (!color(graph, N, i, 2))
                    return false;
            }
        }
        return true;
    }

    boolean color(int[][] graph, int[] N, int n, int c) {
        N[n] = c;
        int nextColor = c == 1 ? 2 : 1;
        for (int i = 0; i < graph[n].length; i++) {
            if (N[graph[n][i]] == -1) {
                if (!color(graph, N, graph[n][i], nextColor))
                    return false;
            }
            else if (N[graph[n][i]] == c)
                return false;
        }
        return true;
    }
}
