package org.sort;

/**
 * 数的小和
 * <p>
 * 左组小于右组产生小和
 * 左组等于右组不产生小和，先拷贝右组
 */
public class Lesson05_SmallSum {


    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + (R - L) / 2;
        return process(arr, L, mid) + process(arr, mid + 1, R) + mergeSort(arr, L, mid, R);
    }


    public static int mergeSort(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = mid + 1;
        int ans = 0;
        while (p1 <= mid && p2 <= R) {
            ans += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= L) {
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


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int sum = Lesson05_SmallSum.smallSum(arr);
        System.out.println(sum);
    }
}
