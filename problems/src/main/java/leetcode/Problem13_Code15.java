package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 排序，双指针
 */
public class Problem13_Code15 {
    public static List<List<Integer>> twoSum(int[] num, int begin, int target) {
        int L = begin;
        int R = num.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            if (num[L] + num[R] < target) {
                L++;
            } else if (num[L] + num[R] > target) {
                R--;
            } else {
                //i与左边的数不相等
                if (L == begin || num[L - 1] != num[L]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[L]);
                    list.add(num[R]);
                    ans.add(list);
                }
                L++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                List<List<Integer>> nexts = twoSum(nums, i + 1, target - nums[i]);
                for (List<Integer> list : nexts) {
                    list.add(nums[i]);
                }
                ans.addAll(nexts);
            }
        }


        return ans;
    }
}
