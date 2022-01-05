package com.roker.study.leetCode.array.No_1;

import com.roker.study.utils.ArrayUtil;

public class Main {
    public static void main(String[] args) {
        int[] data = {2,7,13,13};
        int target = 26;
        int[] res = Solution1.solution(data, target);
        ArrayUtil.print(res);
    }
}
