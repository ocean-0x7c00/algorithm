package org.monotonous;

import java.util.Stack;

/**
 * 给定一个只包含正数的数组arr，arr中任何一个子数组sub，
 * 一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
 * 那么所有子数组中，这个值最大是多少
 */
public class Lesson25_03 {
    public static int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }


        int N = arr.length;
        int[] sums = new int[N];
        for (int i = 0; i < arr.length; i++) {
            sums[i] = arr[i] + (i - 1 < 0 ? 0 : sums[i - 1]);
        }

        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                Integer j = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int total = sums[i - 1] - (leftIndex < 0 ? 0 : sums[leftIndex]);

                max = Math.max(max, total * arr[j]);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer j = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int total = sums[N - 1] - (leftIndex < 0 ? 0 : sums[leftIndex]);
            max = Math.max(max, total * arr[j]);

        }
        return max;
    }
}
