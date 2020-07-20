package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class _954 {
    public boolean canReorderDoubled(int[] A) {
        if (A.length == 0)
            return true;
        else if (A.length%2 == 1)
            return false;
        boolean[] mark = new boolean[A.length];
        Arrays.fill(mark, false);
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (!mark[i]) {
                mark[i] = true;
                if (A[i] < 0) {
                    if (A[i]%2 == 1)
                        return false;
                    int pair = binarySearch(A, A[i]/2);
                    while (pair < mark.length && mark[pair])
                        pair++;
                    if (pair >= mark.length)
                        return false;
                    if (A[pair] != A[i]/2)
                        return false;
                    mark[pair] = true;
                }
                else if (A[i] > 0) {
                    int pair = binarySearch(A, A[i]*2);
                    while (pair < mark.length && mark[pair])
                        pair++;
                    if (pair >= mark.length)
                        return false;
                    if (A[pair] != A[i]*2)
                        return false;
                    mark[pair] = true;
                }
                else if (A[i] == 0) {
                    int pair = binarySearch(A, 0);
                    while (pair < mark.length && mark[pair])
                        pair++;
                    if (pair >= mark.length)
                        return false;
                    if (A[pair] != 0)
                        return false;
                    mark[pair] = true;
                }
            }
        }
        return true;
    }

    int binarySearch(int[] A, int target) {
        int left = 0, right = A.length-1, mid;
        while (left <= right) {
            mid = (left+right)/2;
            if (A[mid] < target)
                left = mid+1;
            else if (A[mid] > target)
                right = mid-1;
            else if (A[mid] == target) {
                if (mid == 0)
                    return mid;
                while (mid-1 >= 0 && A[mid-1] == A[mid])
                    mid--;
                return mid;
            }
        }
        return left;
    }

    public void run() {
        Scanner javaIn = new Scanner(System.in);
        int n = javaIn.nextInt();
        int[] N = new int [n];
        for (int i = 0; i < n; i++)
            N[i] = javaIn.nextInt();
        System.out.println(canReorderDoubled(N));
    }
}
