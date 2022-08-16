package org.recursion;

/**
 * 从左往右的尝试
 * <p>
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。返回你能装下最多的价值是多少?
 */
public class Lesson20_01Knapsack {

    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        return process(0, bag, w, v);
    }

    /**
     * index:[0...w.length-1]
     * rest:[-1...bag]
     *
     * @param index
     * @param rest
     * @param w
     * @param v
     * @return
     */
    public static int process(int index, int rest, int[] w, int[] v) {

        //w[7],v[15],bag=6，下一个位置的无效解
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process(index + 1, rest, w, v);

        int p2 = 0;
        int next = process(index + 1, rest - w[index], w, v);


        //无效的货物不能加
        if (next != -1) {
            p2 = v[index++] + next;
        }


        return Math.max(p1, p2);
    }


    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }


        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                //无效的货物不能加
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);

            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {7};
        int[] values = {15};
        int bag = 6;
        //42
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
