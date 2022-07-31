package org.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部排列
 * 清除现场的技巧
 */
public class Lesson18_03PrintAllPermutations {

    /**
     * 第一种求全排列的方式
     * 不是很好，可变参数设计不好。
     * 递归最讲究的是可变参数的设计
     * 如何评价递归可变参数的优劣？
     *
     * @param rest
     * @param ans
     * @param path
     */
    public static void process1(List<Character> rest, List<String> ans, String path) {
        if (rest.isEmpty()) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            Character cur = rest.get(i);
            rest.remove(cur);
            process1(rest, ans, path + cur);
            rest.add(i, cur);
        }
    }

    /**
     * 把第i个位置的字母换到index的位置
     * [1,2,3]
     * <p>
     * i用来表示以i开头的字符，先把以i开头的字符换到index的位置
     * 求以1开头的字符串
     * 求以2开头的字符串
     * 求以3开头的字符串
     *
     * @param rest
     * @param index 以rest[index]开头的字符串
     * @param ans
     */
    public static void process2(char[] rest, int index, List<String> ans) {
        if (index == rest.length) {
            ans.add(String.valueOf(rest));
            return;
        }
        for (int i = index; i < rest.length; i++) {
            swap(rest, index, i);
            process2(rest, index + 1, ans);
            swap(rest, index, i);
        }


    }

    /**
     * 去重
     *
     * @param rest
     * @param index
     * @param ans
     */
    public static void process3(char[] rest, int index, List<String> ans) {
        if (index == rest.length) {
            ans.add(String.valueOf(rest));
            return;
        }
        //剪枝
        //字符对应的数字，就是存储在visited的位置
        boolean[] visited = new boolean[256];
        for (int i = index; i < rest.length; i++) {
            if (!visited[rest[i]]) {
                visited[rest[i]] = true;
                swap(rest, index, i);
                process3(rest, index + 1, ans);
                swap(rest, index, i);
            }
        }

    }

    public static void permutation1(String str) {

        List<String> ans = new ArrayList<>();
        String path = "";
        List<Character> rest = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            rest.add(chars[i]);
        }
        process1(rest, ans, path);
        System.out.println("ans size" + ans.size());

        ans.forEach(System.out::println);
    }

    public static void permutation2(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        process2(chars, 0, ans);
        System.out.println("ans size" + ans.size());
        ans.forEach(System.out::println);
    }

    public static void permutation3(String str) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        process3(chars, 0, ans);
        System.out.println("ans size" + ans.size());
        ans.forEach(System.out::println);
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abc";
        permutation1(str);
        System.out.println("=============");
        permutation2(str);
        System.out.println("=============");
        permutation3(str);
    }
}
