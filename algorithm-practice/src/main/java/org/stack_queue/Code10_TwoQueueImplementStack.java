package org.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如何用队列结构实现栈结构
 */
public class Code10_TwoQueueImplementStack {

    public static class MyStack {
        Queue<Integer> queue = new LinkedList();
        Queue<Integer> help = new LinkedList();


        public void push(int value) {
            queue.offer(value);
        }

        public Integer poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            Integer ans = queue.poll();
            Queue temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public Integer peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            Integer ans = queue.poll();
            help.offer(ans);

            Queue temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }


}
