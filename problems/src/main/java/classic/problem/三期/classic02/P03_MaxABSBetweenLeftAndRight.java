package classic.problem.三期.classic02;

public class P03_MaxABSBetweenLeftAndRight {
    public static int maxABS(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int min = Math.min(arr[0], arr[arr.length - 1]);

        return Math.abs(max - min);
    }
}
