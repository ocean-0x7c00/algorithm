package leetcode;

public class Problem29_Code42 {
    public int trap(int[] height) {
        return 0;
    }

    private static class Solution {
        /**
         * 双指针法
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            if (height == null || height.length < 2) {
                return 0;
            }
            int L = 1;
            int R = height.length - 2;
            int maxLeft = height[0];
            int maxRight = height[height.length - 1];
            int water = 0;
            while (L <= R) {
                if (maxLeft <= maxRight) {
                    water += Math.max(maxLeft - height[L], 0);
                    maxLeft = Math.max(maxLeft, height[L++]);
                } else {
                    water += Math.max(maxRight - height[R], 0);
                    maxRight = Math.max(maxRight, height[R--]);
                }
            }
            return water;
        }
    }
}
