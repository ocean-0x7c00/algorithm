package org.sort;

/**
 * 在一个数组中，
 * 任何一个前面的数a，和任何一个后面的数b，
 * 如果(a,b)是降序的，就称为逆序对
 * 返回数组中所有的逆序对
 * <p>
 * <p>
 * 求x右边有多少个数比它小，就会产生多少个降序对
 */
public class Lesson05_ReversePair {

    public static int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + (R - L) / 2;
        return process(arr, L, mid) + process(arr, mid + 1, R) + mergeSortFromRight(arr, L, mid, R);
    }

    /**
     * 从左往右mergeSort
     * <p>
     * 求左组有多少个元素比右组小
     * <p>
     * 对于左组的元素x来说
     * 希望求出右组有多少个元素比x小，如果相等，先拷贝右组的元素
     *
     * @param arr
     * @param L
     * @param mid
     * @param R
     * @return
     */
    private static int mergeSortFromLeft(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;

        int p1 = L;
        int p2 = mid + 1;

        int count = 0;
        while (p1 <= mid && p2 <= R) {
            count += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
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


        return count;
    }


    /**
     * 求右组有多少个元素比左组小
     * <p>
     * 对于左组的元素x来说
     * 希望求出右组有多少个元素比x小，如果相等，先拷贝右组的元素
     *
     * @param arr
     * @param L
     * @param mid
     * @param R
     * @return
     */
    private static int mergeSortFromRight(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int index = help.length - 1;
        int p1 = mid;
        int p2 = R;

        int count = 0;


        while (p1 >= L && p2 > mid) {
            count += arr[p1] > arr[p2] ? (p2 - mid) : 0;

            help[index--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[index--] = arr[p1--];
        }

        while (p2 > mid) {
            help[index--] = arr[p2--];
        }

        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return count;
    }

    public static void main(String[] args) {
        //(3,1) (3,0) (3,2)
        //(1,0)
        //(7,0) (7,2)

        int[] arr = {3, 1, 7, 0, 2};
        int count = reverPairNumber(arr);
        System.out.println(count);

    }


}
