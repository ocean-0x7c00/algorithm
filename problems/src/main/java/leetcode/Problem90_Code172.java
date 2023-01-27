package leetcode;

/**
 * 技巧题
 * 5因子的数量
 */
public class Problem90_Code172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
