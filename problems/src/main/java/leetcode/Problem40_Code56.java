package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 合并区间
 */
public class Problem40_Code56 {
    /**
     * 1.根据开始位置排序，
     * 2.设置两个变量，开始位置s，结束位置e
     * 3.下一个开始位置有没有比结束位置大
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Range[] arr = new Range[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            arr[i] = new Range(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(arr, (a, b) -> a.start - b.start);
        ArrayList<Range> ans = new ArrayList<>();
        int s = arr[0].start;
        int e = arr[0].end;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start > e) {
                ans.add(new Range(s, e));
                s = arr[i].start;
                e = arr[i].end;
            } else {
                e = Math.max(e, arr[i].end);
            }
        }

        ans.add(new Range(s, e));
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).start;
            res[i][1] = ans.get(i).end;
        }
        return res;
    }


    public static class Range {
        public int start;
        public int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
