package leetcode;

public class Problem30_Code44 {
    /**
     * 最原始的版本，会超时
     * <p>
     * base case
     * si终止时的base case
     * 1.si来到终止位置：si==s.length()
     * a.pi也来到终止位置：pi=p.length
     * b.pi没来到终止位置：pi位置的字符必须是* 并且从pi+1位置开始，也能匹配到空串
     * <p>
     * <p>
     * <p>
     * 2.pi来到终止位置:pi==p.length
     * a.si==s.length，才能匹配成功
     * <p>
     * 一般情况分类
     * s[si]->都是小写字母
     * p[pi]->小写字母、？、* 三种
     * <p>
     * a.*
     * 前缀长度为0，
     * 前缀长度为1，
     *
     * @param s
     * @param p
     * @param si 从si开始的字符串
     * @param pi
     * @return
     */
    public static boolean process(char[] s, char[] p, int si, int pi) {
        //base case
        //si来到最后一个位置的base case
        if (si == s.length) {
            if (pi == p.length) {
                //s：空串，p：空串，自然能匹配到
                return true;
            } else {
                return p[pi] == '*' && process(s, p, si, pi + 1);
            }
        }
        if (pi == p.length) {
            return si == s.length;
        }

        //base case end
        //p可能有三种字符：小写字母、？、*

        //case1:只有小写字母
        if (p[pi] != '?' && p[pi] != '*') {
            return s[si] == p[pi] && process(s, p, si + 1, pi + 1);
        }

        //case2:只有？
        if (p[pi] == '?') {
            return process(s, p, si + 1, pi + 1);
        }


        //case3:只有*
        //pi位置认为没匹配到字符，由pi+1位置匹配，process(s, p, si, pi + 1);
        //pi位置认为匹配到一个字符，剩余由pi+1位置匹配，process(s, p, si + 1, pi + 1);
        //pi位置认为匹配到两个字符，剩余由pi+1位置匹配process(s, p, si + 2, pi + 1);
        for (int len = 0; len <= s.length - si; len++) {
            if (process(s, p, si + len, pi + 1)) {
                return true;
            }
        }


        //case4 匹配不上
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        boolean match = new Problem30_Code44().isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba");
        long end = System.currentTimeMillis();

        boolean match2 = new Problem30_Code44().isMatch2("adceb", "*a*b");

        System.out.println(end - start);
    }

    /**
     * 暴力尝试
     * 样本对应模型
     * 斜率优化
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return process(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    /**
     * 根据暴力递归改动态规划
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch2(String str, String pattern) {
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int N = s.length;
        int M = p.length;

        boolean[][] dp = new boolean[N + 1][M + 1];
        //base case
        //si来到最后一个位置的base case
        dp[N][M] = true;
        for (int pi = M - 1; pi >= 0; pi--) {
            dp[N][pi] = (p[pi] == '*' && dp[N][pi + 1]);
        }

        //base case end
        //p可能有三种字符：小写字母、？、*
        for (int si = N - 1; si >= 0; si--) {
            for (int pi = M - 1; pi >= 0; pi--) {

                //case1:只有小写字母
                if (p[pi] != '?' && p[pi] != '*') {
                    dp[si][pi] = (s[si] == p[pi] && dp[si + 1][pi + 1]);
                    continue;
                }

                //case2:只有？
                if (p[pi] == '?') {
                    dp[si][pi] = dp[si + 1][pi + 1];
                    continue;
                }


                //case3:只有*
                //可以通过斜率优化来优化这个枚举行为
                for (int len = 0; len <= s.length - si; len++) {
                    if (dp[si + len][pi + 1]) {
                        dp[si][pi] = true;
                        break;
                    }
                }


            }
        }

        return dp[0][0];
    }

    /**
     * 动态规划之斜率优化
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch3(String str, String pattern) {
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int N = s.length;
        int M = p.length;

        boolean[][] dp = new boolean[N + 1][M + 1];
        //base case
        //si来到最后一个位置的base case
        dp[N][M] = true;
        for (int pi = M - 1; pi >= 0; pi--) {
            dp[N][pi] = (p[pi] == '*' && dp[N][pi + 1]);
        }

        //base case end
        //p可能有三种字符：小写字母、？、*
        for (int si = N - 1; si >= 0; si--) {
            for (int pi = M - 1; pi >= 0; pi--) {

                //case1:只有小写字母
                if (p[pi] != '?' && p[pi] != '*') {
                    dp[si][pi] = (s[si] == p[pi] && dp[si + 1][pi + 1]);
                    continue;
                }

                //case2:只有？
                if (p[pi] == '?') {
                    dp[si][pi] = dp[si + 1][pi + 1];
                    continue;
                }


                //case3:只有*
                //可以通过斜率优化来优化这个枚举行为
                //观察临近的格子看看能不能把斜率优化掉
                //p[pi] == '*'
                dp[si][pi] = dp[si][pi + 1] || dp[si + 1][pi];

            }
        }

        return dp[0][0];
    }

}
