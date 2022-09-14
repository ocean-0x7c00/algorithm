package org.sort.tmp;

public class BinarySearch {
    /**
     * 闭区间[]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 左闭右开[)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int L = 0;
        int R = nums.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid;
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        while (L + 1 < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid - 1;
            }
        }
        if (nums[L] == target) {
            return L;
        }
        if (nums[R] == target) {
            return R;
        }
        return -1;
    }

    /**
     * 找大于等于target最左的位置
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * @param nums
     * @param target
     * @return
     */
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
