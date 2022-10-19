package leetcode;

public class Problem41_Code62 {
    /**
     * 初次调用，n，m不为0
     * 最大公约数，辗转相除法
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);

    }

    /**
     * 不同路径问题
     * C()
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return 0;
    }
}
