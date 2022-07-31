package org.recursion;

/**
 * 汉诺塔问题
 */
public class Lesson18_01Hanoi {
    private static String msg = "Move %s from %s to %s";

    public static void hanoi(int n) {
        if (n > 0) {
            process(n, "left", "right", "mid");
        }
    }

    /**
     * 递归的方式求汉诺塔问题
     * <p>
     * 1.将N-1个元素从from移动到other上（递归）
     * 2.将第N个元素从from移动到to上 （打印）
     * 3.将N-1个元素从other上移动到to上 （递归）
     *
     * 时间复杂度
     * O(2^N - 1 ) ,移动2^N - 1步
     * @param n     汉诺塔的层数
     * @param from
     * @param other
     * @param to
     */
    public static void process(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println(String.format(msg, 1, from, to));
            return;
        }
        //n-1 从from移动到other
        process(n - 1, from, other, to);
        System.out.println(String.format(msg, n, from, to));
        process(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        hanoi(64);
    }
}
