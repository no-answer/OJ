package LeetCode;

public class LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int X = 0, Y = 0;
        while (X <= x && Y <= y) {
            if (X == x && Y == y)
                return true;
        }
        return false;
    }
}
