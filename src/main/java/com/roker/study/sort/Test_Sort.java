package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2021/02/24 10:03
 * @Title Test_Sort
 * @Description 测试Sort
 */

public class Test_Sort extends Sort {

    public static void main(String[] args) {
        sort(0,arr.length);
        ArrayUtil.print(arr);
    }

    private static void sort(int begin, int end) {
        if ((end - begin) < 2) return;

        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private static int pivotIndex(int begin, int end) {
        int random = (int) (Math.random() * (end - 1 -begin) + begin);
        int pivot = arr[random];
        ArrayUtil.swap(arr,begin,random);

        end--;

        while(begin < end){
            while(begin < end){
                if (arr[end] > pivot){
                    end--;
                }else {
                    arr[begin++] = arr[end];
                    break;
                }
            }
            while(begin < end){
                if (arr[begin] < pivot){
                    begin++;
                }else{
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }

        arr[begin] = pivot;
        return begin;
    }
}
