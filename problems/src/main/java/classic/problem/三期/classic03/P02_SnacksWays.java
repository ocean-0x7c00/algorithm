package classic.problem.三期.classic03;

public class P02_SnacksWays {

    /**
     * 背包问题
     * 递归
     *
     * @param arr
     * @param w
     * @return
     */
    public static int ways1(int[] arr, int w) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process(arr, w, 0);
    }

    /**
     * 从左往右的尝试模型
     *
     * @param arr
     */
    public static int process(int[] arr, int rest, int index) {
        //背包没容量了
        if (rest < 0) {
            return -1;
        }

        if (index == arr.length) {
            return 1;
        }

        int p1 = process(arr, rest, index + 1);
        int p2 = process(arr, rest - arr[index], index + 1);

        return p1 + (p2 != -1 ? p2 : 0);
    }


    /**
     * 动态规划
     *
     * @param arr
     * @param w
     * @return
     */
    public static int ways2(int[] arr, int w) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][w + 1];
        for (int i = 0; i <= w; i++) {
            dp[N][i] = 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i + 1][j] + (j - arr[i] >= 0 ? dp[i + 1][j - arr[i]] : 0);
            }
        }
        return dp[0][w];
    }

    /**
     * @param arr
     * @param w
     * @return
     */
    public static int ways3(int[] arr, int w) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N][w + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= w) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = dp[i - 1][j] + (j - arr[i] >= 0 ? dp[i - 1][j - arr[i]] : 0);
            }
        }
        int ans = 0;
        for (int j = 0; j <= w; j++) {
            ans += dp[N - 1][j];
        }
        return ans;
    }

    /**
     * 动态规划，空间压缩技巧
     *
     * @param arr
     * @param w
     * @return
     */
    public static int ways4(int[] arr, int w) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 9};
        int w = 8;
        System.out.println(ways1(arr, w));
        System.out.println(ways2(arr, w));
        System.out.println(ways3(arr, w));

    }
}
