package leetcode;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class Problem24_Code34 {
    public static void main(String[] args) {
        int[] ints = new Problem24_Code34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftMost = leftMost(nums, target);
        int rightMost = rightMost(nums, target);

        if (leftMost != -1 && rightMost != -1 && leftMost <= rightMost) {
            return new int[]{leftMost, rightMost};
        }

        return new int[]{-1, -1};
    }

    public int leftMost(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int M = 0;
        int index = -1;
        while (L <= R) {
            M = L + (R - L) / 2;
            if (target <= nums[M]) {
                R = M - 1;
                index = M;
            } else {
                L = M + 1;
            }
        }
        return index;
    }

    public int rightMost(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int M = 0;
        int index = -1;
        while (L <= R) {
            M = L + (R - L) / 2;
            if (target >= nums[M]) {
                L = M + 1;
                index = M;
            } else {
                R = M - 1;
            }
        }
        return index;
    }

    public static class Solution {
        public static int leftMost(int[] nums, int target) {
            int L = 0;
            int R = nums.length;
            int index = -1;
            while (L < R) {
                int mid = L + (R - L) / 2;
                if (nums[mid] >= target) {
                    index = mid;
                    R = mid;
                } else {
                    L = L + 1;
                }

            }
            return index;
        }

        /**
         * 找大于等于target最右的位置
         *
         * @param nums
         * @param target
         * @return
         */
        public static int rightMost(int[] nums, int target) {
            int L = 0;
            int R = nums.length;
            int index = -1;
            while (L < R) {
                int mid = L + (R - L) / 2;
                if (nums[mid] <= target) {
                    index = mid;
                    L = L + 1;
                } else {
                    R = mid;
                }

            }
            return index;
        }

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int leftIndex = leftMost(nums, target);
            int rightIndex = rightMost(nums, target);
            if (leftIndex != -1 && rightIndex != -1 && leftIndex <= rightIndex) {
                return new int[]{leftIndex, rightIndex};
            }
            return new int[]{-1, -1};
        }
    }
}
