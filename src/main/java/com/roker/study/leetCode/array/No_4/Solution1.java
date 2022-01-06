package com.roker.study.leetCode.array.No_4;

/**
 *简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
 * */
public class Solution1 {
    public static double solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ints = new int[len1 + len2];
        //判断数组1是否为空，为空则取数组2的中位数
        if (len1 == 0){
            return len2 % 2 == 0 ? (nums2[len2/2 - 1] + nums2[len2 / 2]) / 2.0 : nums2[len2/2];
        }
        //判断数组2是否为空，为空则取数组1的中位数
        if (len2 == 0){
            return len1 % 2 == 0 ? (nums1[len1/2 - 1] + nums1[len1 / 2]) / 2.0 : nums1[len1/2];
        }
        //设置中间变量 sizeCount-总计数，i-数组1计数，j-数组2计数
        int sizeCount = 0;
        int i = 0;
        int j = 0;
        while (sizeCount != (len1 + len2)){
            //如果数组1，已经循环完毕，则将数组2后面的数据以此放到数组ints中
            if (i == len1){
                while(j != len2){
                    ints[sizeCount++] = nums2[j++];
                }
                break;
            }
            //如果数组2，已经循环完毕，则将数组1后面的数据以此放到数组ints中
            if (j == len2){
                while(i != len1){
                    ints[sizeCount++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]){
                ints[sizeCount++] = nums1[i++];
            }else {
                ints[sizeCount++] = nums2[j++];
            }
        }
        int mid = ints.length / 2;
        int flag = ints.length % 2;
        return  flag == 0 ? (ints[mid] + ints[mid - 1])/2.0 : ints[(ints.length - 1)/2];

    }
}
/**
 * 时间复杂度：遍历全部数组 (m+n)
 * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
 * */


