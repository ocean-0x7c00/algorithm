package org.stack_queue;

import java.util.Stack;

public class Code08_GetMinStack {
    public static class MyStack {
        Stack<Integer> stack = new Stack();
        Stack<Integer> minStack = new Stack();

        public int pop() {
            stack.pop();
            minStack.pop();
            return 0;
        }

        public void push(int val) {
            stack.push(val);
            Integer peek = minStack.peek();
            if (peek == null || peek <= val) {
                minStack.push(peek);
            } else {
                minStack.push(val);
            }
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
