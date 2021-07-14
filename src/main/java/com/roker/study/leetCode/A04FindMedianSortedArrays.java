package com.roker.study.leetCode;

import com.roker.study.utils.ArrayUtil;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

/**
 * @Author Roker
 * @Date 2021/07/12 15:31
 * @Title A04FindMedianSortedArrays
 * @Description
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */

public class A04FindMedianSortedArrays {
    public static void main(String[] args) {
        //定义俩个nums
        int[] numsA = {};
        int[] numsB = {1};
        //结果
        double median = 0;
//       median = method1(numsA, numsB);

        median = method2(numsA, numsB);
        median = method3(numsA, numsB);
        System.out.println("中位数：" + median);

    }

    /**
     * @param nums1
     * @param nums2
     * @return
     * 时间复杂度：O(log(min(M,N)))，
     * 为了使得搜索更快，我们把更短的数组设置为 nums1 ，因为使用二分查找法，在它的长度的对数时间复杂度内完成搜索；
     * 空间复杂度：O(1)，只使用了常数个的辅助变量。

     */
    private static double method3(int[] nums1, int[] nums2) {
        //替换引用，方便编码
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }

    /**
     * 实现归并排序、得到中位数
     * @param nums1
     * @param nums2
     * @return
     */
    private static double method2(int[] nums1, int[] nums2) {
        
        return 0;
    }

    /**
     * 暴力解法：合并以、排序、得到中位数
     * 合并数组后再取中位数
     * @return
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     */
    private static double method1(int[] numsA, int[] numsB) {
        int a = numsA.length;
        int b = numsB.length;
        int[] nums = new int[a + b];
        int len = nums.length;

//        //数组numsA为空情况
//        if (a == 0){
//            if (b % 2 ==0){//numsB 为偶情况
//                return (numsB[b / 2 - 1 ] + numsB[b / 2]) / 2.0;
//            }else {
//                return numsB[b / 2];
//            }
//        }
//        //数组numsB为空情况
//        if (b == 0){
//            if (a % 2 ==0){//numsB 为偶情况
//                return (numsA[a / 2 - 1] + numsA[a / 2]) / 2.0;
//            }else {
//                return numsA[a / 2];
//            }
//        }
        //合并俩个数组
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (aIndex < a && bIndex < b){
            if (numsA[aIndex] < numsB[bIndex]){
                nums[index++] = numsA[aIndex++];
            }else {
                nums[index++] = numsB[bIndex++];
            }
        }
        if (aIndex < a){
            System.arraycopy(numsA,aIndex,nums,index,a - aIndex);
        }
        if (bIndex < b){
            System.arraycopy(numsB,bIndex,nums,index,b - bIndex);
        }

        ArrayUtil.print(nums);
        if (len % 2 ==0){//numsB 为偶情况
            return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
        }else {
            return nums[len / 2];
        }
    }
}
