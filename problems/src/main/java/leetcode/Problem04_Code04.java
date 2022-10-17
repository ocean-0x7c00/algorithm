package leetcode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n))
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * @author yancy
 * @version 1.0.0
 * @since 2022/10/13 16:11
 */
public class Problem04_Code04 {
  /**
   * 1.取偶数个
   * arr1[1,2,3,4],（1,2,3,4）表示范围上的第几个
   * arr2[1',2',3',4']
   * 怎么知道arr1和arr2混在一起之后第4'小的数是哪个呢？
   *
   * 2.取奇数个
   *
   * 结论：子数组的上中位数，是原数组的中位数
   * 等长数组求上中位数
   *
   *
   * @param arr1
   * @param L1
   * @param R1
   * @param arr2
   * @param L2
   * @param R2
   * @return
   */
  public static int f(int[] arr1, int L1, int R1, int[] arr2, int L2, int R2) {

    return 0;
  }

  public static void main(String[] args) {

  }

  /**
   * 1.两个有序数组arr1,arr2,找第k个数，k>=1
   * int g(arr1,arr2,k)
   * <p>
   * 2.若arr1和arr2有序且长度相等，返回arr1和arr2排完序的整体中位数(返回上中位数，
   * 因为长度一样的数组，合并之后新数组的长度一定是偶数)
   * int f(arr1，L1,R1,arr2,L2,R2)
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return 0.0;
  }



}
