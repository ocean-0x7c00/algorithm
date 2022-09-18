package classic.problem.三期.classic02;

public class P04_TrappingRainWater {
    /**
     * 双指针法
     *
     * @param arr
     * @return
     */
    public static int water1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int L = 1;
        int R = arr.length - 2;
        int maxLeft = arr[0];
        int maxRight = arr[arr.length - 1];
        int water = 0;
        while (L <= R) {
            if (maxLeft <= maxRight) {
                water += Math.max(maxLeft - arr[L], 0);
                maxLeft = Math.max(maxLeft, arr[L++]);
            } else {
                water += Math.max(maxRight - arr[R], 0);
                maxRight = Math.max(maxRight, arr[R--]);
            }
        }
        return water;
    }
}
