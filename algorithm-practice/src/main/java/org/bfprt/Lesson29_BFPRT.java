package org.bfprt;

import static org.sort.quick.Lesson06_PartitionAndNetherlands.swap;

public class Lesson29_BFPRT {
    /**
     * 快排改写
     *
     * @param arr
     * @param k
     * @return
     */
    public static int minKth1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length;
        int[] range = null;
        while (L < R - 1) {
            int pivot = (int) (Math.random() * 10);
            range = partition(arr, L, R, k);
            if (k >= range[0] && k <= range[1]) {
                return pivot;
            } else if (k < range[0]) {
                R = range[0] - 1;
            } else {
                L = range[1] + 1;
            }
        }
        return arr[L];
    }

    public static int process(int[] arr, int L, int R, int index) {
        if (L == R) {
            return arr[L];
        }
        int pivot = arr[L + (int) (Math.random() * (R - L + 1))];
        int[] range = partition(arr, L, R, pivot);
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return process(arr, L, range[0] - 1, index);
        } else {
            return process(arr, range[1] + 1, R, index);
        }

    }

    public static int[] partition(int[] arr, int L, int R, int pivot) {
        int lessR = L - 1;
        int moreL = R + 1;

        int index = L;
        while (L < moreL) {
            if (pivot < arr[index]) {
                lessR++;
                index++;
            } else if (pivot > arr[index]) {
                moreL--;
            } else {
                index++;
            }
        }
        return new int[]{lessR + 1, moreL - 1};
    }


    /**
     * 1.每5个数分一组
     * 2.小组内排好序
     * 3.每个数组中的中位数组成一个新的数组
     * 4.返回中位数数组的中位数
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int medianOfMedians(int[] arr, int L, int R) {
        int size = R - L + 1;
        int offset = (size % 5) == 0 ? 0 : 1;
        int[] mArr = new int[size / 5 + offset];
        for (int team = 0; team < mArr.length; team++) {
            int start = L + team * 5;
            mArr[team] = getMedian(arr, start, Math.min(R, start + 4));
        }

        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int L, int R) {

        insertionSort(arr, L, R);
        return arr[(L + R) / 2];
    }

    public static void insertionSort(int[] arr, int L, int R) {
        for (int i = L + 1; i <= R; i++) {
            for (int j = i - 1; j >= L && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static int bfprt(int[] arr, int L, int R, int index) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
