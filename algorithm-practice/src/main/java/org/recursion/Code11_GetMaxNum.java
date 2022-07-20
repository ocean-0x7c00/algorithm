package org.recursion;

/**
 * 求数组中的最大值
 * 通过这个问题理解递归
 * <p>
 * 1.递归何时结束
 */
public class Code11_GetMaxNum {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    /**
     * arr[L..R] 范围上求最大值 L...R  N个数
     *
     * @param arr
     * @param L
     * @param R
     */
    public static int process(int[] arr, int L, int R) {
        //arr[L..R]范围上只有一个数，直接返回，base case
        if (L == R) {
            return arr[L];
        }

        // L...R 不只一个数
        int mid = L + (R - L) / 2;
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(rightMax, leftMax);
    }
}
