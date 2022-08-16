package org.slider;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 假设一个固定大小为W的窗口，依次划过arr，返回每一次滑出状况的最大值例如，
 * arr = [4,3,5,4,3,3,6,7], W = 3返回：[5,5,5,4,6,7]
 */
public class Lesson24_01SlidingWindowMaxArray {


    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

//        [L,R)
        //存下标
        Deque<Integer> qmax = new LinkedList();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }

            qmax.addLast(R);

            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }


            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }

        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxWindow = getMaxWindow(arr, 3);
        for (int i = 0; i < maxWindow.length; i++) {
            System.out.print(maxWindow[i] + "\t");
        }
    }

}
