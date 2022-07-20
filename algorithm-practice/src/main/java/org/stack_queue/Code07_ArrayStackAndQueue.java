package org.stack_queue;

/**
 * 基于数组实现的栈和队列
 */
public class Code07_ArrayStackAndQueue {
    public static class MyStack {
        /**
         *
         */
        static int[] stack = new int[10];
        static int top = -1;

        public static int pop() {
            if (top == -1) {
                return -1;
            }
            return stack[top--];
        }

        public static void push(int data) {
            if (top == stack.length - 1) {
                return;
            }
            stack[++top] = data;
        }

    }

    public static class MyQueue {
        private final int limit;
        private int[] arr;
        private int rear;// end
        private int front;// begin
        /**
         * 个数
         */
        private int size;

        public MyQueue(int limit) {
            rear = 0;
            front = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (rear == limit) {
                throw new RuntimeException("队列满了");
            }
            size++;
            arr[rear] = value;
            rear = nextIndex(rear);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列为空");
            }
            size--;
            int val = arr[front];
            front = nextIndex(front);

            return val;
        }

        private int nextIndex(int i) {
            return i < limit - 1 ? i++ : 0;
        }
    }
}
