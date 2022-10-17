package leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * <p>
 * 思路
 * 利用求余和取整
 */
public class Problem06_Code07 {
    public static void main(String[] args) {
        int reverse = new Problem06_Code07().reverse(Integer.MAX_VALUE);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        //先判断x是不是负数，如果不是，转为负数处理。因为：负数表达的范围比正数表达的范围打一个
        //怎么判断一个数是不是负数？ >>> 无符号右移
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        //准备判断溢出
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;

        int res = 0;
        while (x != 0) {
            //准备判断溢出
            //res<m
            //
            if (res < m || (res == m && x % 10 < o)) {
                return 0;
            }


            res = res * 10 + x % 10;
            x = x / 10;
        }
        return neg ? res : Math.abs(res);
    }
}
