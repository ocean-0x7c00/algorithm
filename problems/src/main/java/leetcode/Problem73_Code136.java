package leetcode;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * 使用异或操作，异或数组中的所有的数，结果就是出现基数次的数
 * 异或：相同为0，相异为1
 */
public class Problem73_Code136 {
    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        return eor;
    }
}
