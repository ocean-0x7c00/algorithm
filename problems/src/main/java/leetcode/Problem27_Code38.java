package leetcode;

public class Problem27_Code38 {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        if (n == 1) {
            return "1";
        }
        char[] chars = countAndSay(n - 1).toCharArray();

        StringBuffer ans = new StringBuffer();
        return ans.toString();
    }
}
