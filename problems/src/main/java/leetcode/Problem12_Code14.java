package leetcode;

public class Problem12_Code14 {
    public static void main(String[] args) {
        String s = new Problem12_Code14().longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        });
        System.out.println(s);
    }

    /**
     * 认为第一个元素是最长公共串，然后遍历，每次遇到不同的字符停止
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[] chars = strs[0].toCharArray();
        //避免干扰正确答案
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            int index = 0;
            while (index < chars.length && index < tmp.length) {
                if (chars[index] != tmp[index]) {
                    break;
                }
                index++;
            }
            min = Math.min(min, index);
        }

        return strs[0].substring(0, min);
    }
}
