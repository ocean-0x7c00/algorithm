package classic.problem.三期.classic01;

public class P03_ColorLeftRight {
    public static int minPaint(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] strs = s.toCharArray();

        //枚举[0..0], [1..N]
        //枚举[0..1], [2..N]
        //枚举[0..2], [3..N]
        //枚举[0..N-1], [N..N]
        int rightNum = 0;
        for (int i = 0; i < strs.length; i++) {
            rightNum += strs[i] == 'R' ? 1 : 0;
        }


        //都是右侧范围
        int res = rightNum;
        int leftGNum = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            //0..i上有多少个G
            leftGNum += strs[i] == 'G' ? 1 : 0;

            //i+1...N上有几个R
            rightNum -= strs[i] == 'R' ? 1 : 0;

            res = Math.min(res, leftGNum + rightNum);
        }
        //都是左侧没有右侧
        res = Math.min(res, leftGNum + (strs[strs.length - 1] == 'G' ? 1 : 0));
        return res;
    }

    public static void main(String[] args) {
        String test = "GRRGGGR";
        System.out.println(minPaint(test));

    }
}
