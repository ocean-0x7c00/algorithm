package org.monotonous;

public class Lesson25_02 {
    public static int[] method(int[] arr) {
        int[] sum = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            sum[i] = arr[i] + (i - 1 < 0 ? 0 : sum[i - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int[] method = method(arr);
        System.out.println();
    }
}
