package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class o40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> q = new PriorityQueue<>(cmp);
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!q.isEmpty() && arr[i] < q.peek()) {
                q.poll();
                q.add(arr[i]);
            }
        }
        int[] Q = new int[q.size()];
        for (int i = 0; !q.isEmpty(); i++) {
            Q[i] = q.poll();
        }
        return Q;
    }

    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
}
