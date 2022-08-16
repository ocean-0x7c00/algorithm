package org.recursion;

/**
 * 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文arr每一个字符串，
 * 代表一张贴纸，你可以把单个字符剪开使用，
 * 目的是拼出str来返回需要至少多少张贴纸可以完成这个任务。
 * 例子：str= "babac"，arr = {"ba","c","abcd"}ba + ba + c  3  abcd + abcd 2  abcd+ba
 * 2所以返回2
 * <p>
 * 贴纸顺序无关
 *
 * <p>
 * https://leetcode.com/problems/stickers-to-spell-word
 */

public class Lesson20_03StickersToSpellWord {
    public static int minStickers1(String[] stickers, String target) {
        return process(stickers, target);
    }

    public static int process(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            String rest = rest(sticker, target);
            if (rest.length() != target.length()) {
                min = Math.min(min, process(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String rest(String target, String sticker) {
        char[] str1 = sticker.toCharArray();
        char[] str2 = target.toCharArray();
        int[] count = new int[26];
        for (char cha : str1) {
            count[cha - 'a']++;
        }
        for (char cha : str2) {
            count[cha - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    builder.append((char) (i + 'a'));
                }
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        System.out.println(minStickers1(stickers, target));
    }
}
