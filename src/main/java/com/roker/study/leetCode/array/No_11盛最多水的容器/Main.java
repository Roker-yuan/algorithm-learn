package com.roker.study.leetCode.array.No_11盛最多水的容器;

public class Main {
    public static void main(String[] args) {
        int[] init = {1,8,6,2,5,4,8,3,7};
        int res = 0;
//        res = Solution0.solution(init);
        res = Solution1.solution(init);
        System.out.println(res);
    }
}
