package leetcode;

/**
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 */
public class Problem22_Code29 {
    /**
     * 不用任何运算法计算除法，位运算
     * <p>
     * 知识点
     * 1.求两个数相加的进位信息 (a&b)<<1
     * 2.两个数相加a^b(异或)|(a&b)<<1
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        return 0;
    }


    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            //无进位相加
            sum = a ^ b;

            //进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;

    }


    public int negNum(int n) {
        return add(~n, 1);
    }

    public int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public int multi(int a, int b) {
        int res = 0;
        while (b != 0) {

        }
        return 0;
    }
}
