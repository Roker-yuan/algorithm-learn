package com.roker.study.leetCode.array.No_4;

public class Solution2 {
    public static double solution(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int size = len1 + len2;
        int left = -1;
        int right = -1;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i <= size / 2; i++) {

            if (index1 < len1 && (len2 <= index2 || nums1[index1] < nums2[index2])){
                right = nums1[index1++];
            }else {
                right = nums2[index2++];
            }
            left = right;
        }


        if ((size & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }
}
/*
*
时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)。

空间复杂度：我们申请了常数个变量，也就是 m，n，len，left，right，aStart，bStart 以及 i。

总共 8 个变量，所以空间复杂度是 O(1）。
* */