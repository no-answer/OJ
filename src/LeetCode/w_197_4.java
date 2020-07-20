package LeetCode;

public class w_197_4 {
    public double getMinDistSum(int[][] positions) {
        double x = 0, y = 0;
        for (int i = 0; i < positions.length; i++) {
            x += positions[i][0];
            y += positions[i][1];
        }
        x /= positions.length;
        y /= positions.length;
        double sum = 0;
        for (int i = 0; i < positions.length; i++) {
            sum += Math.sqrt(Math.pow(x-positions[i][0], 2)+Math.pow(y-positions[i][1], 2));
        }
        return sum;
    }
}
