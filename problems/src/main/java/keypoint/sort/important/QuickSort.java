package keypoint.sort.important;

import static utils.ArrayUtils.swap;

/**
 * 快排
 */
public class QuickSort {


    /**
     * 在L...R的范围上做划分
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessR = -1;

        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, ++lessR, index);
            }
            index++;
        }
        swap(arr, ++lessR, R);


        return lessR;
    }


    /**
     * 在L...R的范围上做荷兰国旗问题
     *
     * @param arr
     * @param L
     * @param R
     * @return 返回等于区域左边界和右边界
     */
    public static int[] netherlands(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }

        if (L == R) {
            return new int[]{L, R};
        }

        //小于区域右边界，
        int lessR = L - 1;

        //大于区域左边界
        int moreL = R;
        int index = L;
        while (index < R) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }

        swap(arr, moreL, R);


        return new int[]{lessR + 1, moreL };
    }


    public static class PartitionAndNetherlandsFlag {
        /**
         * lessR小于等于区域的开头
         * i<=num,当前数i与小于等于区的下一个数交换，小于等于区域扩一个位置，i++
         * i>num,i++
         * 直到i==arr.length停
         *
         * @param arr
         * @param num
         */
        public static void partition(int[] arr, int num) {
            int lessR = -1;
            int index = 0;
            while (lessR < arr.length) {

            }
        }


        /**
         * [i]==num,i++;
         * [i]<num,swap[arr,lessR+1,i],lessR++,i++;
         * [i]>num,swap[arr,moreL-1,i],moreL--,i停在原地;
         *
         * @param arr
         * @param num
         */
        public static void netherlandsFlag(int[] arr, int num) {

        }
    }
}
