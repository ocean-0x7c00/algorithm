package classic.problem.三期.classic02;

import java.util.Arrays;

public class P07_KthMinPair {
    /**
     * 暴力打印所有数值对
     *
     * @param arr
     */
    public static void brutalPrintPair(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(String.format("(%s,%s)", arr[i], arr[j]));
            }
        }
    }

    /**
     * 最优解
     * <p>
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     *
     * @param arr
     * @param K
     * @return
     */
    public static int[] kthMinPair(int[] arr, int K) {
        int N = arr.length;
        if (K > N * N) {
            return null;
        }

        //1.第K小的数值对，第一维数是什么
        //在无序数组中，可以求无序数组中的第K小的数 bfprt算法和快排
        int firstNum = getMinKth(arr, arr[(K - 1) / N] + 1);

        //2.找出<=firstNum的数
        int lessFirstNumSize = 0;//数出比fristNum小的数有几个
        int fristNumSize = 0; // 数出==fristNum的数有几个
        for (int i = 0; i < N && arr[i] <= firstNum; i++) {
            if (arr[i] < firstNum) {
                lessFirstNumSize++;
            } else {
                fristNumSize++;
            }
        }

        //3.求firstNum形成的数值对中，第rest小的数
        int rest = K - lessFirstNumSize * N;

        //4.计算第二位数据的位置
        return new int[]{firstNum, arr[(rest - 1) / fristNumSize]};
    }

    public static int getMinKth(int[] arr, int index) {
        int L = 0;
        int R = arr.length - 1;
        int pivot = 0;
        while (L < R) {
            pivot = arr[L + (int) (Math.random() * (R - L + 1))];
            int[] range = partition(arr, L, R, pivot);
            if (index < range[0]) {
                R = range[0] - 1;
            } else if (index > range[0]) {
                R = range[1] + 1;
            } else {
                return pivot;
            }

        }
        return arr[L];
    }


    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(5 % 3);
        brutalPrintPair(arr);
    }
}
