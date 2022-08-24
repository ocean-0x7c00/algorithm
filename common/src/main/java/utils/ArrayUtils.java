package utils;

public class ArrayUtils {
    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        return null;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
