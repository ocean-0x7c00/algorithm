package org.manacher;

public class Lesson29_01 {

    /**
     * 求回文的最长子串的长度
     *
     * @param s
     * @return
     */
    public static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);


        int[] pArr = new int[str.length];
        int R = -1;

        //R-1位置的回文半径中心点
        int C = -1;
//        用来记录字符串的位置
        int end = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;


            while (i + pArr[i] < str.length && i - pArr[i] > -1) {

                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }

            max = Math.max(max, pArr[i]);
            end = R - 1;
        }


        return max - 1;
    }

    public static char[] manacherString2(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            //i & 1 == 0 表示偶数为
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] str = new char[2 * chars.length + 1];
        str[0] = '#';
        int index = 1;
        for (int i = 0; i < chars.length; i++) {
            str[index++] = chars[i];
            str[index++] = '#';
        }


        return str;
    }

    public static void main(String[] args) {
//        int babad = manacher("babad");
//        System.out.println();
//
        String babad1 = new Lesson29_01().longestPalindrome("a");
        System.out.println();
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        //记录max最大时R的位置
        int endR = -1;

        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
            endR = R - 1;
        }


        int length = max - 1;
        int start = (endR - 1) / 2 - length;

        start = start < 0 ? 0 : start;
        int index = 0;
        char[] chars = s.toCharArray();
        char[] result = new char[length];
        for (int i = start; i < length; i++) {
            result[index] = chars[i];
            index++;
        }

        return new String(result);
    }

    public char[] manacherString1(String s) {
        char[] chars = s.toCharArray();
        char[] str = new char[2 * chars.length + 1];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            str[index++] = ((i & 1) == 0) ? '#' : chars[i];
        }
        return str;
    }
}
