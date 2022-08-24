package classic;

/**
 * 给定一个正整数M，请构造出一个长度为M的数组arr，
 * 要求对任意的i、j、k三个位置，如果i<j<k，都有arr[i] + arr[k] != 2*arr[j]
 * 返回构造出的arr
 * <p>
 * 思路
 * 左边是奇数、右边是偶数
 * 给定M=7
 * 需要一个长度为4的种子，可以加工出左边的四个数，
 * <p>
 * 长度为M的数组可以有种子数组逐步构建
 * arr[i] + arr[k] != 2*arr[j]  可以往奇偶数方面联想
 * 奇数+偶数=奇数
 */
public class Problem_006_MakeNo {

    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }

        int halfSize = (size + 1) / 2;

        int[] base = makeNo(halfSize);
        int[] ans = new int[size];

        int index = 0;
        for (; index < halfSize; index++) {
            ans[index] = base[index] * 2 - 1;
        }

        for (int i = 0; index < size; i++, index++) {
            ans[index] = base[i] * 2;
        }


        return ans;
    }
}
