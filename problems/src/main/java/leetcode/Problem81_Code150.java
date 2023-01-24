package leetcode;

import java.util.Stack;

/**
 * 堆栈
 */
public class Problem81_Code150 {
    public static void compute(Stack<Integer> stack, String op) {
        Integer num1 = stack.pop();
        Integer num2 = stack.pop();
        int ans = 0;
        switch (op) {
            case "+":
                ans = num1 + num2;
                break;
            case "-":
                ans = num2 - num1;
                break;
            case "*":
                ans = num1 * num2;
                break;
            case "/":
                ans = num2 / num1;
                break;
        }

        stack.push(ans);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                compute(stack, token);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}
