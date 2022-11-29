package leetcode;

import java.util.HashMap;

public class Problem47_Code76 {
    /**
     * O(N)
     * 1.建立欠账表
     * <p>
     * 2.
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer integer = map.get(c);
            if (integer == null) {
                map.put(c, 1);
            } else {
                map.put(c, integer + 1);
            }
        }

        char[] strs = s.toCharArray();
        char[] target = t.toCharArray();
        int L = 0;
        int R = 0;
        int all = target.length;

        // -1(从来没找到过合法的)
        int minLen = -1;
        int ansl = -1;
        int ansr = -1;

        while (R != strs.length) {
            Integer integer = map.get(strs[R]);

        }

        return null;
    }
}
