package leetcode;

public class Problem38_Code53 {
    /**
     * 动态规划
     * 考虑以i结尾的子数组
     * <p>
     * 1.只有i自己
     * 1.dp[i-1]的最好情况+i
     * dp[i],以i结尾的所有子数组中，最大累加和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int p1 = nums[i];
            int p2 = nums[i] + dp[i - 1];
            dp[i] = Math.max(p1, p2);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
