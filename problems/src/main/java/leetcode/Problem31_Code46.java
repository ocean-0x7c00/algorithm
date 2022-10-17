package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Problem31_Code46 {
    public static void process(int[] arr, int index, List<List<Integer>> ans) {
        if (index == arr.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int num : arr) {
                cur.add(num);
            }
            ans.add(cur);

        } else {
            for (int j = index; j < arr.length; j++) {
                swap(arr, j, index);
                process(arr, index + 1, ans);
                swap(arr, j, index);
            }

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Problem31_Code46().permute(new int[]{1, 2, 3});
        System.out.println();
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        process(nums, 0, ans);
        return ans;
    }
}
