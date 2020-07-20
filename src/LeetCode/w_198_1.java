package LeetCode;

public class w_198_1 {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles+num(numBottles, numExchange);
    }

    int num(int empty, int numE) {
        if (empty < numE)
            return 0;
        int temp = empty/numE;
        return temp+num(temp+empty%numE, numE);
    }
}
