package leetcode;

public class Problem44_Code70 {
    public static int process(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return process(n - 1) + process(n - 2);
    }

    public static void main(String[] args) {
        int i = new Problem44_Code70().climbStairs(4);
        int process = process(4);
        System.out.println();
    }

    /**
     * 类似斐波那契数列一定有logN的解
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
