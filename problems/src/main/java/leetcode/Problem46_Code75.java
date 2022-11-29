package leetcode;

public class Problem46_Code75 {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 荷兰国旗问题
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int less = -1;
        int more = nums.length;
        int index = 0;
        while (index < more) {
            int num = nums[index];
            if (num == 1) {
                index++;
            } else if (num < 1) {
                swap(nums, ++less, index++);
            } else {
                swap(nums, --more, index);
            }
        }

    }
}
