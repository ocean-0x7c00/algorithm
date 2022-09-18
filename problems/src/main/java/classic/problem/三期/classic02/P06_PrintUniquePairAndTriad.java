package classic.problem.三期.classic02;

public class P06_PrintUniquePairAndTriad {
    /**
     * 二元组
     *
     * @param arr
     * @param k
     */
    public static void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int N = arr.length;
        int L = 0;
        int R = N - 1;

        while (L < R) {
            if (arr[L] + arr[R] < k) {
                L++;
            } else if (arr[L] + arr[R] > k) {
                R--;
            } else {
                if (L - 1 < 0 || arr[L] != arr[L - 1]) {
                    System.out.println(arr[L] + "\t" + arr[R]);
                }
                L++;
            }
        }
    }

    /**
     * 三元组
     *
     * @param arr
     * @param k
     */
    public static void printUniqueTriad(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                printRest(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }

    }

    public static void printRest(int[] arr, int i, int L, int R, int k) {

        while (L < R) {
            if (arr[L] + arr[R] < k) {
                L++;
            } else if (arr[L] + arr[R] > k) {
                R--;
            } else {
                if (i == L - 1 || arr[L] != arr[L - 1]) {
                    System.out.println(arr[i] + "\t" + arr[L] + "\t" + arr[R]);
                }
                L++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        int k = 10;
        printUniquePair(arr, k);
        System.out.println("==========");
        printUniqueTriad(arr, k);
    }
}
