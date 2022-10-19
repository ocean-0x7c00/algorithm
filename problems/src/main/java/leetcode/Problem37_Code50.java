package leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class Problem37_Code50 {
    /**
     * x>1,N是正数时肯定对
     */
    public static void pow(int x, int n) {
        int pow = 0;
        double t = x;
        double ans = 1D;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                ans *= t;
            }
            pow >>= 1;
            t *= t;
        }

    }

    /**
     * 快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1D;
        }

        int pow = Math.abs(n == Integer.MIN_VALUE ? n + 1 : n);
        double t = x;
        double ans = 1D;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                ans *= t;
            }
            pow >>= 1;
            t *= t;
        }

        if (n == Integer.MIN_VALUE) {
            ans *= x;
        }
        return n < 0 ? (1D / ans) : ans;
    }
}
