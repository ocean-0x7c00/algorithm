package leetcode;

public class Problem94_Code_191 {
    public int hammingWeight(int n) {
        int bits = 0;
        int rightOne = 0;
        while (n != 0) {
            rightOne = n & (-n);
            n ^= rightOne;
            bits++;
        }
        return bits;
    }
}
