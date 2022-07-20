package org.sort;

/**
 * 这道题直接在leetcode测评：
 * <p>
 * https://leetcode.com/problems/count-of-range-sum/
 */
public class Lesson_CountOfRangeSum {

    /**
     * 1.以每个位置结尾且达标的数组个数
     * 2.一个数组的累加和达标 sum(i,j)在 [lower,upper]等价于sum(0,j) -sum(0,i)在[lower,upper]
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] presum = new long[nums.length];
        presum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        return process(presum, 0, nums.length - 1, lower, upper);
    }

    public static int process(long[] arr, int L, int R, int lower, int upper) {
        if (L == R) {
            return arr[L] >= lower && arr[L] <= upper ? 1 : 0;
        }
        int mid = L + (R - L) / 2;
        return process(arr, L, mid, lower, upper)
                + process(arr, mid + 1, R, lower, upper)
                + merge(arr, L, mid, R, lower, upper);
    }

    public static int merge(long[] arr, int L, int mid, int R, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for (int i = mid + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowL <= mid && windowR <= max) {
                windowR++;
            }
            while (windowL <= mid && windowL < min) {
                windowL++;
            }

            ans += (windowR - windowL);
        }

        long[] help = new long[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    /**
     * 暴力解法
     * 枚举子数组，求和判断
     * O(N^3) -> O(N^2)
     * <p>
     * 0-0
     * 0-1
     * 0-2
     * 0-3
     * 0-n
     * <p>
     * <p>
     * 1-1
     * 1-2
     * 1-3
     * 1-n
     */
    public static int brutalCountRangeSum(int[] nums, int lower, int upper) {

        int count = 0;
        //根据以x结尾为标准，枚举所有子数组
        //根据以x开头为标准，枚举所有子数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                long sum = 0;
                for (int k = j; k <= i; k++) {
                    sum += nums[k];
                }
                if (sum >= lower && sum <= upper) {
                    count++;
                }

                //枚举所有子数组
                System.out.println(String.format("(%s,%s), sum=%s", nums[j], nums[i], sum));
            }
        }

        return count;
    }


    /**
     * 求数组前缀和
     *
     * @param arr
     * @return
     */
    public static int getSum(int[] arr, int i, int j) {
        int[] preSum = new int[arr.length];

        preSum[0] = arr[0];
        for (int k = 1; k < arr.length; k++) {
            preSum[k] = preSum[k - 1] + arr[k];
        }
        return i == j ? preSum[j] : preSum[j] - preSum[i];
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};

        int[] arr = {-2,  -5, 1};

        int sum = countRangeSum(arr, -2, 2);
        System.out.println();
        System.out.println(sum);
    }
}
