package leetcode;

import java.util.Stack;

public class Problem16_Code20 {
    public static void main(String[] args) {
        boolean valid = new Problem16_Code20().isValid("([])}");
        System.out.println(valid);
    }

    /**
     * 使用栈
     * 遇到左括号入栈，遇到右括号出栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.add(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character last = stack.pop();
                //当前的字符是),弹出的字符一定是左,否则就是false
                if ((chars[i] == ')' && last != '(') || (chars[i] == ']' && last != '[') || (chars[i] == '}' && last != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
