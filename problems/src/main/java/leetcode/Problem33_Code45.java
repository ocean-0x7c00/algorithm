package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Problem33_Code45 {
    /**
     * 暴力递归
     */
    public static int jumpMinTimes1(int N, int start, int end, int[] arr) {
        return process(arr, N, end, start, new boolean[N]);
    }

    /**
     * @param arr
     * @param end
     * @param index  下标从1开始
     * @param walked walked[i]==false,表示i之前没到过
     * @return
     */
    public static int process(int[] arr, int N, int end, int index, boolean[] walked) {
        if (index == end) {
            return 0;
        }
        if (index < 1 || index > N || walked[index - 1]) {
            return -1;
        }

        walked[index - 1] = true;
        int left = index - arr[index - 1];
        int right = index + arr[index - 1];

        int p1 = process(arr, N, end, left, walked);
        int p2 = process(arr, N, end, right, walked);

        int next = -1;
        if (p1 != -1 && p2 != -1) {
            next = Math.min(p1, p2);
        } else if (p1 != -1) {
            next = p1;
        } else if (p2 != -1) {
            next = p2;
        }

        walked[index - 1] = false;
        if (next == -1) {
            return -1;
        }
        return next + 1;
    }

    public static int process1(int[] arr, int N, int end, int index,int k){
        return 0;
    }

    /**
     * 动态规划
     */
    public static int jumpMinTimes2(int N, int start, int end, int[] arr) {
        return -1;
    }

    /**
     * bfs宽度优先遍历
     * 最优解
     *
     * @param N
     * @param start
     * @param end
     * @param arr
     * @return
     */
    public static int jumpMinTimes3(int N, int start, int end, int[] arr) {
        if (start < 1 || start > N || end < 1 || end > N) {
            return -1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        queue.add(start);
        levelMap.put(start, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int level = levelMap.get(cur);
            if (cur == end) {
                return level;
            } else {
                int left = cur - arr[cur - 1];
                int right = cur + arr[cur - 1];
                if (left > 0 && !levelMap.containsKey(left)) {
                    queue.add(left);
                    levelMap.put(left, level + 1);
                }

                if (right <= N && !levelMap.containsKey(right)) {
                    queue.add(right);
                    levelMap.put(right, level + 1);
                }
            }
        }

        return -1;
    }

    /**
     * 三个变量
     * step=0 ，来到i需要跳step步。当前最少跳几步能到i
     * cur=0，跳的步数不超过step时，最远能调到哪。跳的步数不超过step，最右能到哪
     * next=0，多跳step+1步最远能到哪。跳的步数不超过step+1步，最右能到哪
     * <p>
     * <p>
     * 1.i>cur,step步内不足以到i
     * step++,cur=next;
     * <p>
     * <p>
     * 2.i<=cur，step步内还能到i
     * next=Math.max(next,arr[i])
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int step = 0;
        int cur = 0;
        int next = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > cur) {
                step++;
                cur = next;
            }
            next = Math.max(next, i + nums[i]);

        }
        return step;
    }


}
