package org.slider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整型数组arr，和一个整数num某个arr中的子数组sub，
 * 如果想达标，必须满足：sub中最大值 – sub中最小值 <= num，返回arr中达标子数组的数量
 *
 * 重要结论
 * 1.[L...R]范围上数组达标，那么[L...R]内的子数组都达标
 * 2.[L...R]范围上数组不达标，那么从R向右扩或从L想左扩子数组都不达标
 */
public class Lesson24_02AllLessNumSubArray {


    /**
     * 暴力解
     * 枚举所有子数组
     *
     * @param arr
     * @param sum
     * @return
     */
    public static int brutal(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        List<int[]> result = new ArrayList<>();
        //枚举所有子数组
        //0开头，1开头
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                if (i == j) {
                    int[] ints = {arr[i]};
                    result.add(ints);
                } else {
                    int[] ints = {arr[i], arr[j]};
                    result.add(ints);
                }
            }
        }

        result.forEach(o->{
            System.out.println(Arrays.toString(o));
        });


        return 0;
    }

    public static int num(int[] arr, int sum) {
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));

        int sum = 0;
        brutal(arr, sum);
        System.out.println(num(arr, sum));
    }
}
