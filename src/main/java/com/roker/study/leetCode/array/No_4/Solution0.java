package com.roker.study.leetCode.array.No_4;

import com.roker.study.utils.ArrayUtil;

public class Solution0 {
    public static double solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ints = new int[len1 + len2];
        if (len1 == 0){
            return len2 % 2 == 0 ? (nums2[len2/2 - 1] + nums2[len2 / 2]) / 2.0 : nums2[len2/2];
        }
        if (len2 == 0){
            return len1 % 2 == 0 ? (nums1[len1/2 - 1] + nums1[len1 / 2]) / 2.0 : nums1[len1/2];
        }
        int rec = 0;
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = rec; j < len2; j++) {
                if (i < len1 && nums1[i] < nums2[j]){
                    ints[index++] = nums1[i];
                    break;
                }
                ints[index++] = nums2[j];
                rec = ++j;

            }

        }
        ArrayUtil.print(ints);
        int mid = ints.length / 2;
        int flag = ints.length % 2;
        return  flag == 0 ? (ints[mid] + ints[mid - 1])/2.0 : ints[(ints.length - 1)/2];

    }
}
