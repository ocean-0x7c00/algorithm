package leetcode;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author yancy
 * @version 1.0.0
 * @since 2022/10/13 15:32
 */
public class Problem03_Code03 {
  public static void main(String[] args) {
    int str = new Problem03_Code03().lengthOfLongestSubstring("abcabcbb");
    System.out.println(str);
  }

  /**
   * 思路：
   * 1.
   * 子串以0位置结尾的情况下，最长无重复子串是多长
   * 子串以1位置结尾的情况下，最长无重复子串是多长
   * 子串以i位置结尾的情况下，最长无重复子串是多长
   * <p>
   * pwwkew
   * 子串以0位置结尾的情况下,最长无重复子串是p,长度为1
   * 子串以1位置结尾的情况下,最长无重复子串是pw,长度为2
   * 子串以2位置结尾的情况下,最长无重复子串是w,长度为1
   * 子串以3位置结尾的情况下,最长无重复子串是wk,长度为1
   * 子串以4位置结尾的情况下,最长无重复子串是wke,长度为3
   * 子串以5位置结尾的情况下,最长无重复子串是kew,长度为3
   * <p>
   * 2.假设有一个表记录了i位置往左推最远仍是无重复子串
   * dp[i]表示i位置向左能扩最远的位置
   * <p>
   * 3.来到i位置向左扩多长由哪些因素决定？
   * 假设i位置的元素是a
   * 第一个因素：上次元素a出现的位置
   * 第二个因素：i-1位置结尾的情况下，往左扩多远
   * <p>
   * 这两个因素谁离i最近，谁就是答案
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    char[] chars = s.toCharArray();
    int pre = -1;
    int len = 0;

    int[] map = new int[256];
    for (int i = 0; i < map.length; i++) {
      map[i] = -1;
    }

    for (int i = 0; i < chars.length; i++) {
      pre = Math.max(pre, map[chars[i]]);
      int curLen = i - pre;
      len = Math.max(len, curLen);
      map[chars[i]] = i;
    }

    return len;
  }
}
