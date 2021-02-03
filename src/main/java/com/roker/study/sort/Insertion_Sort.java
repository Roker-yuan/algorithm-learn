package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2021/02/03 16:46
 * @Title Insertion_Sort
 * @Description 插入排序
 */

public class Insertion_Sort {

    public static void main(String[] args) {
        int[] arr = {4,5,2,8,3,7,1,6,9,4,45,0};
        //基础版
        baseInsertionSort(arr);
        //优化
        optimizationInsertionSort(arr);
    }



    private static void baseInsertionSort(int[] arr) {
        for (int begin = 1; begin < arr.length; begin++) {
            int currentIndex = begin;
            while (currentIndex > 0 && arr[currentIndex] < arr[currentIndex - 1]){
                ArrayUtil.swap(arr,currentIndex,--currentIndex);
            }
        }
        ArrayUtil.print(arr);
    }

    /**
     * 优化版-1-是将【交换】转为【挪动】
     * @param arr
     */
    private static void optimizationInsertionSort(int[] arr) {
        for (int begin = 1; begin < arr.length; begin++) {
            int currentIndex = begin;
            int currentValue = arr[begin];
            while (currentIndex > 0 && arr[currentIndex] < arr[currentIndex - 1]) {
                arr[currentIndex] = arr[currentIndex - 1];
                currentIndex--;
            }
            arr[currentIndex] = currentValue;
        }
    }
}
