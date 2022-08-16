package org.monotonous;

import java.util.*;

/**
 * 单调栈
 */
public class Lesson25_01MonotonousStack {

    // arr = [ 3, 1, 2, 3]
    //         0  1  2  3
    //  [
    //     0 : [-1,  1]
    //     1 : [-1, -1]
    //     2 : [ 1, -1]
    //     3 : [ 2, -1]
    //  ]
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer pop = stack.pop();
                //left
                res[pop][0] = stack.isEmpty() ? -1 : stack.peek();

                //right
                res[pop][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            res[pop][0] = stack.isEmpty() ? -1 : stack.peek();
            res[pop][1] = -1;
        }

        return res;
    }

    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            while (!stack.isEmpty()) {
                LinkedList<Integer> pop = stack.pop();
                if (arr[i] < arr[stack.peek().getLast()]) {
                    res[i][0] = stack.isEmpty() ? -1 : stack.peek().getLast();
                    res[i][1] = pop.getLast();
                } else if (arr[i] == arr[stack.peek().getLast()]) {
                    pop.add(i);
                    if (!pop.isEmpty()) {
                        stack.push(pop);
                    }
                }
                if (!pop.isEmpty()) {
                    stack.push(pop);
                }
            }
            list.add(i);
            stack.push(list);
        }

        while (!stack.isEmpty()) {

        }


        return res;
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3};
        int[][] nearLessNoRepeat = getNearLessNoRepeat(arr);
        System.out.println(Arrays.toString(nearLessNoRepeat));
    }
}
