package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2021/02/03 15:32
 * @Title Selection_Sort
 * @Description 选择排序
 */

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {4,5,2,8,3,7,1,6,9,4,45,0};

        //基础版
        baseSelectionSort(arr);

    }

    /*
    执行流程
        ① 从序列中找出最大的那个元素，然后与最末尾的元素交换位置
        ✓ 执行完一轮后，最末尾的那个元素就是最大的元素
        ② 忽略 ① 中曾经找到的最大元素，重复执行步骤 ①
    */
    private static void baseSelectionSort(int[] arr) {

        for (int end = arr.length - 1; end > 0 ; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (arr[begin] > arr[maxIndex]){
                    maxIndex = begin;
                }
            }
            ArrayUtil.swap(arr,maxIndex,end);
        }

        ArrayUtil.print(arr);
    }
}
