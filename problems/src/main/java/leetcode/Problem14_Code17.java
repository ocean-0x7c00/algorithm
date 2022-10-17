package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力递归
 */
public class Problem14_Code17 {
    public static char[][] phone = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},};

    public static void process(char[] strs, int index, char[] paths, List<String> ans) {
        if (index == strs.length) {
            ans.add(String.valueOf(paths));
        } else {
            char[] cands = phone[strs[index] - '2'];
            for (char cur : cands) {
                paths[index] = cur;
                process(strs, index + 1, paths, ans);
            }

        }
    }

    public static void main(String[] args) {
        List<String> strings = new Problem14_Code17().letterCombinations("23");
        System.out.println();
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();

        char[] strs = digits.toCharArray();
        char[] paths = new char[strs.length];

        process(strs, 0, paths, ans);

        return ans;
    }
}
