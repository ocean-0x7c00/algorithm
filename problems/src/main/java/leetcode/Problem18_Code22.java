package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem18_Code22 {
    /**
     * 剪枝
     * <p>
     * 依次在path上填写决定
     * ( ( ) ) ( )
     * 0 1 2 3 4 5
     * path[0..index-1]决定已经做完了
     * 在Index位置上，放置( 或 ）
     *
     * @param path
     * @param index
     * @param leftMinusRight 已经做过决定的区域左-右的数量
     * @param leftRest
     * @param ans
     */
    public static void process(char[] path, int index, int leftMinusRight, int leftRest, List<String> ans) {
        if (index == path.length) {
            ans.add(String.valueOf(path));
            return;
        }

        //做左括号的决定
        if (leftRest > 0) {
            path[index] = '(';
            process(path, index + 1, leftMinusRight + 1, leftRest - 1, ans);
        }

        //做右括号的决定
        if (leftMinusRight > 0) {
            path[index] = ')';
            process(path, index + 1, leftMinusRight - 1, leftRest, ans);
        }
    }

    /**
     * 最原始的版本
     *
     * @param path
     * @param index
     * @param ans
     */
    public static void process(char[] path, int index, List<String> ans) {
        if (index == path.length) {
            if (isValid(path)) {
                ans.add(String.valueOf(path));
            }
            return;
        }

        path[index] = '(';
        process(path, index + 1, ans);

        path[index] = ')';
        process(path, index + 1, ans);
    }

    private static boolean isValid(char[] paths) {
        int count = 0;
        for (char path : paths) {
            if (path == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    /**
     * 动态规划
     * <p>
     * 如果求数量，可以直接用卡特兰数
     * 暴力递归
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        char[] path = new char[n << 1];
        ArrayList<String> ans = new ArrayList<>();
        process(path, 0, 0, n, ans);
        return ans;
    }
}
