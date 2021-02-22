package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;


/**
 * @Author Roker
 * @Date 2021/02/03 17:18
 * @Title Merge_Sort
 * @Description 归并排序（Merge Sort）
 */

public class Merge_Sort extends Sort{
    private static int[] leftArray;
    private static int[] array = arr;

    public static void main(String[] args) {
        //准备一个新的数组，用来备份需要交换的子数组序列
        leftArray = new int[array.length >> 1];
        ArrayUtil.print(leftArray);
        mergeSort(array);
        ArrayUtil.print(array);
    }

    private static void mergeSort(int[] array) {
        sort(0,array.length);
    }

    private static void sort(int begin, int end) {
        //排序合法性校验(必须，否则会在递归过程中出现 StackOverflowError)
        if ((end - begin) < 2 ) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin,mid,end);
    }

    private static void merge(int begin, int mid, int end) {
        //左边数组子序列
        int li = 0, le = mid - begin;
        //右边数组子序列
        int ri = mid, re = end;
        //填充指针
        int ai = begin;

        // 备份左边数组
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

        // 如果左边还没有结束
        while (li < le) {
            if (ri < re && (array[ri] -  leftArray[li]) < 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }

    }

}
