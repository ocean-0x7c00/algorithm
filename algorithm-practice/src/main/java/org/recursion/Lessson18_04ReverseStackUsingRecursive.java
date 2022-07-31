package org.recursion;

import java.util.Stack;

/**
 * 给定一个栈，请逆序这个栈
 * 不能申请额外的数据结构，只能使用递归函数
 */
public class Lessson18_04ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack) {
        int bottom = f(stack);
        if (stack.isEmpty()) {
            stack.push(bottom);
            return;
        }
        reverse(stack);
        stack.push(bottom);
    }

    public static int method(Stack<Integer> stack) {
        Integer cur = stack.pop();
        if (stack.isEmpty()) {
            return cur;
        }


        int ans = method(stack);
        stack.push(cur);

        return ans;
    }


    public static int f(Stack<Integer> stack) {
        Integer cur = stack.pop();
        if (stack.isEmpty()) {
            return cur;
        }
        int ans = f(stack);
        stack.push(cur);
        return ans;

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);

        stack.push(2);
        stack.push(1);
        System.out.println(method(stack));
        System.out.println(method(stack));
        System.out.println(method(stack));
        reverse(stack);
        System.out.println();
    }
}
