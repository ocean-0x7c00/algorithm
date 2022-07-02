package org;

/**
 * https://blog.csdn.net/xiao_jj_jj/article/details/106018702
 * <p>
 * [L,R]是每次进行搜索的空间，，被称为搜索空间
 * while(L<=R)的终止条件为left=right+1,写成区间形式[right+1,right]，如[3,2]。此时搜索空间为空，因为没有数字既大于等于 3
 * 又小于等于 2 的吧。所以这时候 while 循环终止是正确的，直接返回 -1 即可
 * <p>
 * while(left < right) 的终止条件是 left == right，写成区间的形式就是 [left, right]，或者带个具体的数字进去 [2, 2]，
 * 这时候搜索区间非空，还有一个数 2，但此时 while 循环终止了。也就是说这区间 [2, 2] 被漏掉了，索引 2 没有被搜索，
 * 如果这时候直接返回 -1 就是错误的
 * <p>
 * 当我们发现索引 mid 不是要找的 target 时，如何确定下一步的搜索区间呢？
 * 当然是 [left, mid - 1] 或者 [mid + 1, right] 对不对？因为 mid 已经搜索过，应该从搜索区间中去除。
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4};
        int target = 3;
//        int index1 = basic1(arr, target);
//        int index2 = basic2(arr, target);
//        int index3 = basic3(arr, target);
//        int index4 = leftmost(arr, target);
        int index5 = rightmost(arr, target);
//        System.out.println(String.format("index1: %s, value: %s", index1, index1 != -1 && index1 < arr.length ? arr[index1] : null));
//        System.out.println(String.format("index2: %s, value: %s", index2, index2 != -1 && index2 < arr.length ? arr[index2] : null));
//        System.out.println(String.format("index3: %s, value: %s", index3, index3 != -1 && index3 < arr.length ? arr[index3] : null));
//        System.out.println(String.format("index4: %s, value: %s", index4, index4 != -1 && index4 < arr.length ? arr[index4] : null));
        System.out.println(String.format("index5: %s, value: %s", index5, index5 != -1 && index5 < arr.length ? arr[index5] : null));

    }

    //basic二分查找算法

    /**
     * []
     *
     * @param arr
     * @param target
     * @return
     */
    public static int basic1(int[] arr, int target) {
        Integer x = checkArray(arr);
        if (x != null) return x;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return -1;
    }

    /**
     * [)
     * <p>
     * 终止条件 L==R [1,1]
     *
     * @param arr
     * @param target
     * @return
     */
    public static int basic2(int[] arr, int target) {
        Integer x = checkArray(arr);
        if (x != null) return x;
        int L = 0;
        int R = arr.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        return L != arr.length && arr[L] == target ? L : -1;
    }


    /**
     * ()
     * 终止条件L+1==R   [0+1,1]
     *
     * @param arr
     * @param target
     * @return
     */
    public static int basic3(int[] arr, int target) {
        Integer x = checkArray(arr);
        if (x != null) return x;
        int L = 0;
        int R = arr.length - 1;
        while (L + 1 < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                L = mid;

            } else {
                R = mid;
            }
        }
        if (arr[L] == target) {
            return L;
        }
        if (arr[R] == target) {
            return R;
        }
        return -1;
    }


    //找最左边界、找最右边界

    /**
     * 找target的最左边界
     * [)
     */
    public static int leftmost(int[] arr, int target) {
        Integer x = checkArray(arr);
        if (x != null) return x;

        int L = 0;
        int R = arr.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
//            if (arr[mid] == target) {
//                R = mid;
//            } else if (arr[mid] < target) {
//                L = mid + 1;
//            } else {
//                R = mid;
//            }
            if (arr[mid] < target) {
                L = mid + 1;
            } else {
                R = mid;
            }

        }

        /**为什么没有返回 -1 的操作？如果 nums 中不存在 target 这个值，怎么办？
         先理解一下这个「左侧边界」有什么特殊含义：
         **/

        //target比所有的数都要大
        if (L == arr.length) {
            return -1;
        }
        return arr[L] == target ? L : -1;

    }

    /**
     * 找target的最右边界
     */
    public static int rightmost(int[] arr, int target) {
        Integer x = checkArray(arr);
        if (x != null) return x;

        int L = 0;
        int R = arr.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] == target) {
                L = mid + 1;
            } else if (arr[mid] < target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }

        //target比所有数都要小

        if (R == 0) {
            return -1;
        }

        return arr[R - 1] == target ? R - 1 : -1;
    }

    private static Integer checkArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return null;
    }

    //二分查找示例
    // 二分查找 --- [left, right]
    // 数组已经是有序的了!
    public static int binarySerach1(int[] nums, int target) {
        Integer x = checkArray(nums);
        if (x != null) return x;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 防止溢出 等同于(left + right)/2
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // target 在左区间，所以[left, middle - 1]
                right = mid - 1;
            } else {
                // target 在右区间，所以[middle + 1, right]
                left = mid + 1;
            }
        }

        return -1;
    }

    // 二分查找 --- [left, right)
    // 数组已经是有序的了!
    int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        // 定义target在左闭右开的区间里，即：[left, right)
        int left = 0, right = nums.length;
        // 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //  target 在右区间，在[middle + 1, right)中
                left = mid + 1;
            } else {
                // target 在左区间，在[left, middle)中
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left != nums.length && nums[left] == target) return left;
        return -1;
    }


    // 二分查找 --- (left, right)
    // 数组已经是有序的了!
    int binarySearch3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //  target 在右区间，在(middle, right)中
                left = mid;
            } else {
                // target 在左区间，在(left, middle)中
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left + 1 == right
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }


}
