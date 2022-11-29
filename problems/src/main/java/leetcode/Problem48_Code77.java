package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem48_Code77 {
    public static void process(int[] arr, int index, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (index == arr.length) {
            ArrayList<Integer> res = new ArrayList<>();
            for (Integer integer : path) {
                res.add(integer);
            }
            ans.add(res);
        } else {
            process(arr, index + 1, path, ans);

            path.addLast(arr[index]);
            process(arr, index + 1, path, ans);
            path.removeLast();
        }


    }

    /**
     * 递归
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        process(nums, 0, path, ans);
        return ans;
    }
}
