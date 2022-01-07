package com.roker.study.leetCode.array.No_11盛最多水的容器;

public class Solution1 {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    /**
     * 优化版本
     */
    public static  int solution(int[] height) {
        int res = 0, h = 0, left = 0, right = height.length - 1;
        while (left < right) {
            h = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * h);
            while (height[left] <= h && left < right)
                left++;
            while (height[right] <= h && left < right) {
                right--;
            }
        }
        return res;
    }
}
