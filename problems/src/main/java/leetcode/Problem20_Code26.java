package leetcode;

public class Problem20_Code26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int done = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[done] != nums[cur]) {
                nums[++done] = nums[cur];
            }
        }
        return done + 1;
    }
}
