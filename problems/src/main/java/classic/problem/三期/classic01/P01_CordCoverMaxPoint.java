package classic.problem.三期.classic01;

import java.util.Arrays;

/**
 * 给定一个有序数组arr，从左到右依次表示X轴上从左往右点的位置
 * 给定一个正整数K，返回如果有一根长度为K的绳子，最多能盖住几个点，
 * 绳子的边缘点碰到X轴上的点，也算盖住
 * 例如有一个数组arr=[1,5,7,13,14]，绳子的长度为L=5，问绳子最多能盖住都少个点？
 */
public class P01_CordCoverMaxPoint {
    /**
     * 二分
     * 枚举绳子结尾，找离绳子开头最左的点
     *
     * @param arr
     * @param L
     * @return
     */
    public static int maxPoint1(int[] arr, int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int leftMost = leftMost(arr, i, arr[i] - L);
            if (leftMost != -1) {
                res = Math.max(res, i - leftMost + 1);
            }
        }
        return res;
    }

    public static int leftMost(int[] arr, int R, int target) {
        int L = 0;
        int index = -1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] >= target) {
                index = mid;
                R = mid;
            } else {
                L = L + 1;
            }
        }
        return index;
    }

    /**
     * 滑动窗口
     *
     * @param arr
     * @param L
     * @return
     */
    public static int maxPoint2(int[] arr, int L) {
        int res = 0;
        int left = 0;
        int right = 0;
        int N = arr.length;
        //枚举开头，以i开始
        while (left < N) {
            //以i开始的线段最长能到什么位置
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }
            res = Math.max(res, right - (left++));

        }

        return res;
    }


    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }


    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }

        System.out.println("测试结束");

    }
}
