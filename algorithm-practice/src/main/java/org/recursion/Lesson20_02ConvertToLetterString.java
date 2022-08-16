package org.recursion;

/**
 * 从左往右的尝试
 * 规定1和A对应、2和B对应、3和C对应...26和Z对应
 * 那么一个数字字符串比如"111”就可以转化为:"AAA"、"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class Lesson20_02ConvertToLetterString {

    public static int number(String str) {
        if (str == null || str.toCharArray().length == 0) {
            return 0;
        }
        return process(0, str.toCharArray());

    }

    // str[0..i-1]转化无需过问
    // str[i.....]去转化，返回有多少种转化方法
    public static int process(int index, char[] strs) {

        //index来到最后一个位置，可以转化为空串
        //index来到最后一个位置，说明[0,index-1]之前的字符串找到了一种转化方法
        if (index == strs.length) {
            return 1;
        }


        //上一次的决定错误，不收集点数
        //105
        if (strs[index] == '0') {
            return 0;
        }
        //1.index的位置转为字符的种数
        int ways = process(index + 1, strs);


        //2.index的位置和index+1的位置共同转为字符的种数
        //index+1>str.length 或index index+1大于26

        if (index + 1 < strs.length && (strs[index] - '0') * 10 + strs[index + 1] - '0' < 27) {
            ways += process(index + 2, strs);
        }
        return ways;
    }

    public static int dp(String str) {
        if (str == null || str.toCharArray().length == 0) {
            return 0;
        }
        char[] strs = str.toCharArray();
        int N = strs.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;

        for (int i = N - 1; i >= 0; i--) {

            //上一次的决定错误，不收集点数
            //105
            int ways = 0;
            if (strs[i] == '0') {
                ways = 0;
            } else {
                //1.index的位置转为字符的种数
                ways = dp[i + 1];


                //2.index的位置和index+1的位置共同转为字符的种数
                //index+1>str.length 或index index+1大于26

                if (i + 1 < strs.length && (strs[i] - '0') * 10 + strs[i + 1] - '0' < 27) {
                    ways += dp[i + 2];
                }
            }
            dp[i] = ways;
        }


        return dp[0];
    }

    public static void main(String[] args) {
        String str = "1111";
        System.out.println(number(str));
        System.out.println(dp(str));

    }
}
