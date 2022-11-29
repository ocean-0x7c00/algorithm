package leetcode;

public class Problem43_Code69 {
    /**
     * 二分
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 3) {
            return 1;
        }
        long ans = 1;
        long L = 1;
        long R = x;
        long M = 0;
        while (L <= R) {
            M = L + (R - L) / 2;
            if (M * M <= x) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }


        return (int) ans;
    }
}
