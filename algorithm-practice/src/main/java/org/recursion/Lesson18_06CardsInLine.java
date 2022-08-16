package org.recursion;

/**
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明
 * 请返回最后获胜者的分数
 */
public class Lesson18_06CardsInLine {

    /**
     * 1.暴力递归的方式
     *
     * @param arr
     * @return
     */
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int first = first1(arr, 0, arr.length - 1);
        int second = second1(arr, 0, arr.length - 1);
        return Math.max(first, second);
    }

    public static int first1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + second1(arr, L + 1, R);
        int p2 = arr[R] + second1(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    public static int second1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int p1 = first1(arr, L + 1, R);
        int p2 = first1(arr, L, R - 1);
        return Math.min(p1, p2);
    }


    /**
     * 记忆化搜索
     *
     * @param arr
     * @return
     */
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] dp1 = new int[arr.length][arr.length];
        int[][] dp2 = new int[arr.length][arr.length];

        int first = first2(arr, 0, arr.length - 1, dp1, dp2);
        int second = second2(arr, 0, arr.length - 1, dp1, dp2);
        return Math.max(first, second);
    }


    public static int first2(int[] arr, int L, int R, int[][] dp1, int[][] dp2) {
        if (L == R) {
            return arr[L];
        }

        int p1 = 0;
        int p2 = 0;
        if (dp2[L + 1][R] != 0) {
            p1 = arr[L] + dp2[L + 1][R];
        } else {
            dp2[L + 1][R] = second2(arr, L + 1, R, dp1, dp2);
            p1 = arr[L] + dp2[L + 1][R];
        }
        if (dp2[L][R - 1] != 0) {
            p2 = arr[R] + dp2[L][R - 1];
        } else {
            dp2[L][R - 1] = second2(arr, L, R - 1, dp1, dp2);
            p2 = arr[R] + dp2[L][R - 1];
        }
        return Math.max(p1, p2);
    }

    public static int second2(int[] arr, int L, int R, int[][] dp1, int[][] dp2) {
        if (L == R) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        if (dp1[L + 1][R] != 0) {
            p1 = dp1[L + 1][R];
        } else {
            dp1[L + 1][R] = first2(arr, L + 1, R, dp1, dp2);
            p1 = dp1[L + 1][R];
        }
        if (dp1[L][R - 1] != 0) {
            p2 = dp1[L][R - 1];
        } else {
            dp1[L][R - 1] = first2(arr, L, R - 1, dp1, dp2);
            p2 = dp1[L][R - 1];
        }

        return Math.min(p1, p2);
    }

    /**
     * 动态规划
     * <p>
     * f表的对角线求s表的对角线
     * s表的对角线求f表的对角线
     *
     * @param arr
     * @return
     */
    public static int win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] dp1 = new int[arr.length][arr.length];
        int[][] dp2 = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp1[i][i] = arr[i];
        }


        //从1开始的对角线，从2开始的对角线.....从N-1开始的对角线

        for (int i = 1; i < arr.length; i++) {
            int row = 0;
            int col = i;
            while (col < arr.length) {
                dp1[row][col] = Math.max(arr[row] + dp2[row + 1][col], arr[col] + dp2[row][col - 1]);
                dp2[row][col] = Math.min(dp1[row + 1][col], dp1[row][col - 1]);

                row++;
                col++;
            }

        }


        return Math.max(dp1[0][arr.length-1],dp2[0][arr.length-1]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }
}
