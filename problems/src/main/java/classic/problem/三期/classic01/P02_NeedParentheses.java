package classic.problem.三期.classic01;

public class P02_NeedParentheses {
    /**
     * 怎么判断一个括号字符串有效
     *
     * @param s
     * @return
     */
    public static boolean valid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int count = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            count += (str[i] == '(') ? 1 : -1;
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }


    /**
     * 如果一个括号字符串无效，返回至少填几个字符能让其整体有效
     *
     * @param s
     * @return
     */
    public static int needParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int needSolveRight = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                count++;
            } else {
                if (count == 0) {
                    needSolveRight++;
                } else {
                    count--;
                }
            }


        }

        return count + needSolveRight;
    }

    public static int deep(String s) {
        return 0;
    }
}

