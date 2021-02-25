package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Roker
 * @Date 2021/02/24 14:48
 * @Title Shell_Sort
 * @Description 希尔排序
 */

public class Shell_Sort extends Sort {
    public static void main(String[] args) {
        shellSort(arr);
        ArrayUtil.print(arr);
    }
    private static void shellSort(int[] arr) {
//        List<Integer> stepSequence = shellStepSequence();
        List<Integer> stepSequence = sedgewickStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    private static void sort(int step) {
        // col : 第几列，column的简称
        for (int col = 0; col < step; col++) { // 对第col列进行排序
            // col、col+step、col+2*step、col+3*step
            for (int begin = col + step; begin < arr.length; begin += step) {
                int cur = begin;
                while (cur > col && ArrayUtil.cmp(arr,cur, cur - step) < 0) {
                    ArrayUtil.swap(arr,cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    /**
     * Shell步长计算
     * 希尔本人给出的步长序列是 𝑛/2𝑘
     * @return
     */
    private static List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = arr.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }


    /**
     * Sedgewick步长计算
     * Robert Sedgewick提出 目前已知的最好的步长序列，最坏情况时间复杂度是 O(n4/3)
     * @return
     */
    private static List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= arr.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }
}
