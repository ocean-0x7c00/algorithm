package leetcode;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Problem42_Code66 {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        for (int i = N - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        int[] ans = new int[N + 1];
        ans[0] = 1;
        return ans;
    }
}
