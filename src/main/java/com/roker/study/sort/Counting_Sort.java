package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2021/02/25 15:55
 * @Title Counting_Sort
 * @Description 计数排序
 */

public class Counting_Sort extends Sort {

    public static void main(String[] args) {
        //基础版
        baseCountingSort();
        ArrayUtil.print(arr);
    }

    /**
     * 基础版本
     */
    private static void baseCountingSort() {

        //找出数组中最大的元素
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        //开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[max + 1];
        //统计每个整数出现的次数
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        //根据整数出现的次数，对原数组进行排序填充
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while(counts[i]-- > 0){
                arr[index++] = i;
            }
        }
    }
}
