package org.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列
 * 打印一个字符串的全部子序列，要求不要出现重复字面值的子序列
 */
public class Lesson18_02PrintAllSubsquences {

    public static void process(char[] strs, int index, List<String> ans, String path) {
        if (index == strs.length) {
            ans.add(path);
            return;
        }

        //没有要当前位置的字符，index+1位置继续递归
        process(strs, index + 1, ans, path);
        process(strs, index + 1, ans, path + strs[index]);
    }

    public static void printAllSub(String str) {
        //打印一个字符串的全部子序列，要求不要出现重复字面值的子序列 使用HashSet收集答案即可
        List<String> ans = new ArrayList<>();
        String path = "";
        process(str.toCharArray(), 0, ans, path);
        System.out.println("ans size=" + ans.size());
        ans.forEach(System.out::println);
    }

    public static void main(String[] args) {
        String str = "acccc";
        printAllSub(str);
    }
}
