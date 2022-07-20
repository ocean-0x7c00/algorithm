package org.sort;

/**
 * 归并排序
 * 时间复杂度O(NlogN)
 */
public class Lesson05_MergeSort {

    public static void mergeSort1(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }


    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;

        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }


        // 要么p1越界了，要么p2越界了
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= R) {
            help[index++] = arr[p2++];
        }


        for (int i = 0; i < help.length; i++) {
            arr[L++] = help[i];
        }
    }


    /**
     * 非递归实现
     *
     * @param arr
     */
    public static void mergeSort2(int[] arr) {
        //TODO
    }

    public static void main(String[] args) {
        int[] arr = {10, 0, 1, 4, 2, 2, 3, 5, 8, 6, 9, 7};
        mergeSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
