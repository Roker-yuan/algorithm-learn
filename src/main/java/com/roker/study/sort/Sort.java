package com.roker.study.sort;

/**
 * @Author Roker
 * @Date 2021/02/22 15:49
 * @Title Sort
 * @Description 排序算法父类
 */

public  class  Sort {

    static int[] arr = {4,5,2,8,3,7,1,6,9,4,45,0};
//    static int[] arr = {4,8,7,6,5};

    //快排
    public int[] quickSort(int[] arr){
        quickSort(arr, 0 , arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int begin, int end) {
        //合法性检验
        if (begin > end ) return;

        int index = pivotIndex(arr, begin , end);
        quickSort(arr, begin, index - 1);
        quickSort(arr, index + 1, end);

    }

    private int pivotIndex(int[] arr, int begin, int end) {

        //选取索引为0即数组的第一个元素作为轴点 pivot
        int pivot = arr[begin];
        while (begin < end){
            //移动end指针，移动条件：当end元素 >= 轴点元素
            while (begin < end && arr[end] >= pivot){
                end--;
            }
            //填坑（end元素前置），条件：上述while循环结束，说明end元素 < 轴点元素
            if (begin < end) arr[begin] = arr[end];
            //移动begin指针，移动条件：当begin元素 <= pivot
            while (begin < end && arr[begin] <= pivot){
                begin++;
            }
            //填坑（begin元素后置），条件：上述while循环结束，说明begin元素 > 轴点元素
            if (begin < end) arr[end] = arr[begin];
        }
        //基准数放到合适的位置
        arr[begin] = pivot;
        return begin;
    }
}
