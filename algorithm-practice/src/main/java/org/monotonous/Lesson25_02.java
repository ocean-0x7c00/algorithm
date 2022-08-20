package org.monotonous;

import java.util.LinkedList;
import java.util.Stack;

public class Lesson25_02 {
    public static int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int N = arr.length;
        int[][] res = new int[N][2];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < arr.length; i++) {
            //求离i位置最近，比i小的位置，栈中元素，从栈底到栈顶一次变大
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                Integer j = stack.pop();
                int lessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[j][0] = lessIndex;
                res[j][1] = i;

            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer j = stack.pop();
            int lessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[j][0] = lessIndex;
            res[j][1] = -1;
        }


        return res;
    }

    public static int[][] getNearLess(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int N = arr.length;
        int[][] res = new int[N][2];
        Stack<LinkedList<Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().peekLast()] > arr[i]) {
                LinkedList<Integer> popi = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().peekLast();
                for (Integer j : popi) {
                    res[j][0] = leftIndex;
                    res[j][1] = i;
                }

            }

            if (!stack.isEmpty() && arr[stack.peek().peekLast()] == arr[i]) {
                stack.peek().addLast(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.addLast(i);
                stack.push(list);
            }

        }

        while (!stack.isEmpty()) {
            LinkedList<Integer> popi = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().peekLast();
            for (Integer j : popi) {
                res[j][0] = leftIndex;
                res[j][1] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};


        System.out.println();
    }
}
