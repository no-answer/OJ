package LeetCode;

import java.util.PriorityQueue;
import java.util.Scanner;

public class bw_30_3 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for (int j = i; j < nums.length; j++) {
                tempSum -= nums[j];
                priorityQueue.add(tempSum);
                if (priorityQueue.size() > right)
                    priorityQueue.poll();
            }
        }
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        while (!priorityQueue.isEmpty())
            priorityQueue1.add(-priorityQueue.poll());
        int sum = 0;
        for (int i = 1; i < left; i++)
            priorityQueue1.poll();
        while (!priorityQueue1.isEmpty()) {
            sum += priorityQueue1.poll();
            sum %= 1000000007;
        }
        return sum;
    }

    public void run() {
        Scanner javaIn = new Scanner(System.in);
        int n = javaIn.nextInt();
        int left = javaIn.nextInt();
        int right = javaIn.nextInt();
        int[] N = new int[n];
        for (int i = 0; i < n; i++)
            N[i] = javaIn.nextInt();
        System.out.println(rangeSum(N, n, left, right));
    }
}
