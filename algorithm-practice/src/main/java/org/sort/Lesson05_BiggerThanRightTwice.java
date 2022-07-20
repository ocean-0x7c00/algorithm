package org.sort;

/**
 * https://leetcode.cn/problems/reverse-pairs/
 * <p>
 * <p>
 * 不回退的技巧的前提是单调性
 */
public class Lesson05_BiggerThanRightTwice {
    public static void main(String[] args) {
//        67132 5
        int[] nums = {6, 7, 1, 3, 2};
        int count = new Lesson05_BiggerThanRightTwice().reversePairs(nums);
        System.out.println(count);
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public int process(int[] nums, int L, int R) {

        if (L == R) {
            return 0;
        }


        int mid = L + (R - L) / 2;
        return process(nums, L, mid) + process(nums, mid + 1, R) + mergeSort(nums, L, mid, R);
    }

    public int mergeSort(int[] nums, int L, int mid, int R) {
        //windowR表示目前满足条件的数 [M+1,windowR)
        //不回退的技巧，原因是左右两部分是单调的，L到mid，windowR到R，指针L和windowR不会回退
        //时间复杂度o(n)，因为指针不会退
        int windowR = mid + 1;
        int ans = 0;

        for (int i = L; i <= mid; i++) {
            while (windowR <= R && nums[i] > 2 * nums[windowR]) {
                windowR++;
            }

            ans += windowR - mid - 1;
        }


        int[] help = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[index++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }

        while (p2 <= R) {
            help[index++] = nums[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[L + i] = help[i];
        }
        return ans;
    }
}
