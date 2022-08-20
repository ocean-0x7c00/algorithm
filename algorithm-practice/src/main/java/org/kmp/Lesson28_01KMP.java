package org.kmp;

/**
 *
 */
public class Lesson28_01KMP {


    public static int kmp(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[] next = getNextArray(str2.toCharArray());

        int x = 0;
        int y = 0;

        //
        while (y < s1.length && x < s2.length) {

            if (s1[y] == s2[x]) {
                x++;
                y++;
            } else if (next[x] == -1) {
                y++;
            } else {
                x = next[x];
            }

        }

        //y-x表示匹配到的开始位置
        return x == s2.length ? y - x : -1;


    }

    private static int[] getNextArray(char[] s2) {
        if (s2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[s2.length];
        next[0] = -1;
        next[1] = 0;

        //在哪个位置就next数组的值
        int i = 2;
        //记录前缀串的下一个字符和i-1位置的字符比较
        int cn = 0;
        while (i < next.length) {
            if (s2[i - 1] == s2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (kmp(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");


        "".indexOf("");
    }

    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }


}
