package com.roker.study.leetCode.array.No_11盛最多水的容器;

public class Solution0 {
    public static int solution(int[] init) {
        int left = 0;
        int right = init.length - 1;
        int maxArea = (right - left) * Math.min(init[left],init[right]);
        while (left < right){
            if (init[left] < init[right]){
                left++;
            }else {
                right--;
            }
            int newArea = (right - left) * Math.min(init[left],init[right]);
            maxArea = Math.max(maxArea,newArea);
        }
        return maxArea;
    }
}
