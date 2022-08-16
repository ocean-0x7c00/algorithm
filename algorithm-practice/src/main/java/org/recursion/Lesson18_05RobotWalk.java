package org.recursion;

/**
 * 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 * 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 */
public class Lesson18_05RobotWalk {

    public static int ways1(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);
    }

    /**
     * 暴力递归
     *
     * @param cur
     * @param rest
     * @param aim
     * @param N
     * @return
     */
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }

        return process1(cur + 1, rest - 1, aim, N) + process1(cur - 1, rest - 1, aim, N);

    }


    public static int ways2(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[K + 1][N + 1];
        return process2(start, K, aim, N, dp);
    }

    /**
     * 记忆化搜索
     * <p>
     * 自顶向下的动态规划
     *
     * @param cur
     * @param rest
     * @param aim
     * @param N
     * @return
     */
    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {

        if (dp[rest][cur] == aim) {
            return dp[rest][cur];
        }

        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }

        int ans = 0;
        if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur + 1, rest - 1, aim, N, dp) + process2(cur - 1, rest - 1, aim, N, dp);

        }

        dp[rest][cur] = ans;

        return ans;

    }


    public static int ways3(int cur, int rest, int aim, int N) {
        int[][] dp = new int[cur + 1][rest + 1];
        dp[aim][0] = 1;

        for (int col = 1; col <= rest; col++) {
            dp[1][col] = dp[2][col - 1];
            for (int row = 2; row < N; row++) {

                dp[row][col] = dp[row - 1][col - 1] + dp[row + 1][col - 1];

            }
            dp[cur][col] = dp[cur - 1][col - 1];
        }


        return dp[cur][rest];

    }

    public static void main(String[] args) {
        System.out.println(ways1(5, 2, 4, 6));
        System.out.println(ways3(6, 2, 4, 5));
    }
}
