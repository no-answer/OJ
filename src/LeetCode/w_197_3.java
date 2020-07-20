package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class w_197_3 {
    class pair {
        public int a;
        public double b;
        pair(int A, double B) {
            a = A;
            b = B;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (edges == null || edges.length == 0 || start == end)
            return 0;
        boolean[] mark = new boolean[n];
        double[] probability = new double[n];
        for (int i = 0; i < n; i++) {
            mark[i] = false;
            probability[i] = 0;
        }
        List<pair>[] matrix = new List[n];
        for (int i = 0; i < n; i++)
            matrix[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]].add(new pair(edges[i][1], succProb[i]));
            matrix[edges[i][1]].add(new pair(edges[i][0], succProb[i]));
        }
        probability[start] = 1.0;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            for (int i = 0; i < matrix[temp].size(); i++) {
                if (!mark[matrix[temp].get(i).a]) {
                    probability[matrix[temp].get(i).a] = matrix[temp].get(i).b;
                    mark[matrix[temp].get(i).a] = true;
                    stack.push(matrix[temp].get(i).a);
                }
                else if (probability[matrix[temp].get(i).a] < matrix[temp].get(i).b) {
                    probability[matrix[temp].get(i).a] = matrix[temp].get(i).b;
                    stack.push(matrix[temp].get(i).a);
                }
            }
        }
        return probability[end];
    }
}
