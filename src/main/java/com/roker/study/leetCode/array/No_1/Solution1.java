package com.roker.study.leetCode.array.No_1;


/**
 *方法一：暴力枚举
 * 思路及算法
 * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
 * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。
 * 而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x
 *
 * */
public class Solution1 {

    public static int[] solution(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
