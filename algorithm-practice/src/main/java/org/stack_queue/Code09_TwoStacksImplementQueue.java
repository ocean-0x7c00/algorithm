package org.stack_queue;

import java.util.Stack;

/**
 * 如何用栈结构实现队列结构
 * 准备两个栈，一个push栈，一个pop栈
 * 遵循两个原则
 * 1.push栈要一次性全部导入pop栈中
 * 2.pop栈不为空，不能导数据
 */
public class Code09_TwoStacksImplementQueue {

    public static class Queue {
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();

        /**
         * push栈向pop栈导数据
         */
        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }


        public void add(int val) {
            stackPush.push(val);
            pushToPop();
        }

        public int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            pushToPop();
            return stackPop.peek();
        }
    }

}
