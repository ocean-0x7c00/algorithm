package org.sort.quick;

/**
 * 给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Lesson06_PartitionAndNetherlands {


    /**
     * arr[L..R]上，以arr[R]位置的数做划分值
     * <= X > X
     * <= X X
     *
     * @param arr
     * @param L
     * @param R
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }

        int index = L;
        int lessEqual = L - 1;

        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }

        swap(arr, ++lessEqual, R);
        return lessEqual;
    }


    /**
     * <x|=x|>X
     *
     * @param arr
     * @param L
     * @param R
     * @return 相等区域的起始位置
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }


        int index = L;
        int less = L - 1;
        int more = R;
        // 当前位置，不能和 >区的左边界撞上
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }


        swap(arr, more, R);
        //返回相等区域
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * partition
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);

    }

    /**
     * netherlands
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }
        int[] ints = netherlandsFlag(arr, L, R);
        process2(arr, L, ints[0] - 1);
        process2(arr, ints[1] + 1, R);
    }

    /**
     * 随机选一个划分值
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void process3(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] ints = netherlandsFlag(arr, L, R);
        process2(arr, L, ints[0] - 1);
        process2(arr, ints[1] + 1, R);
    }

    public static int method(int L, int R) {
        int num = L + (int) (Math.random() * (R - L + 1));
        if (num >= L && num <= R) {
            System.out.println(num);
        } else {
            System.out.println("error");
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 9, 3};
//        partition(arr, 0, arr.length - 1);
//        netherlandsFlag(arr, 0, arr.length - 1);

//        quickSort1(arr);
//        quickSort2(arr);
        System.out.println();
        method(1, 7);
    }
}
