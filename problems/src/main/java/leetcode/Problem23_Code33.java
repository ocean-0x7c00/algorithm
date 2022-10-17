package leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 */
public class Problem23_Code33 {
    /**
     * 二分，条件讨论
     * <p>
     * 1.L、M、R三者不全相等就可以使用二分
     * 2.L、M、R三者全相等就可以使用二分
     * L++移动到
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int M = 0;
        while (L <= R) {
            M = L + (R - L) / 2;
            if (nums[M] == target) {
                return M;
            }

            //nums[M]!=target
            if (nums[L] == nums[M] && nums[M] == nums[R]) {
                while (L < M && nums[L] == nums[M]) {
                    L++;
                }
                if (L == M) {
                    L = M + 1;
                    continue;
                }
            }

            //nums[M]!=target
            //L、M、R不都一样
            if (nums[L] != nums[M]) {

                if (nums[M] > nums[L]) {
                    if (target >= nums[L] && target < nums[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                } else {
                    //nums[L] > nums[M]右侧一定有序
                    if (target > nums[M] && target <= nums[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }

            } else {
                //L==M =>M!=R
                if (nums[M] < nums[R]) {
                    if (target > nums[M] && target <= nums[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;

                    }
                } else {
                    if (target < nums[M] && target >= nums[L]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }

                }

            }

        }
        return -1;
    }
}
