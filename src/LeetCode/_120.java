package LeetCode;

import java.util.Arrays;
import java.util.List;

public class _120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] array = new int [2][triangle.get(triangle.size()-1).size()+1];
            Arrays.fill(array[0], 0);
            Arrays.fill(array[1], 0);
            array[0][0] = triangle.get(0).get(0);
            int mark1 = 0, mark2 = 1, min = Integer.MAX_VALUE;
            for (int i = 1; i < triangle.size(); i++) {
                array[mark2][0] = triangle.get(i).get(0)+array[mark1][0];
                for (int j = 1; j < triangle.get(i).size()-1; j++) {
                    array[mark2][j] = Math.min(triangle.get(i).get(j)+array[mark1][j], triangle.get(i).get(j)+array[mark1][j-1]);
                }
                array[mark2][triangle.get(i).size()-1] = triangle.get(i).get(triangle.get(i).size()-1)+array[mark1][triangle.get(i).size()-2];
                int temp = mark1;
                mark1 = mark2;
                mark2 = temp;
            }
            for (int i = 0; i < triangle.size(); i++) {
                min = Math.min(min, array[mark1][i]);
            }
            return min;
        }
    }
}
