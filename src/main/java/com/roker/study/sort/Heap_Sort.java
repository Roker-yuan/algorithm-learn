package com.roker.study.sort;

import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2021/02/03 16:16
 * @Title Heap_Sort
 * @Description 堆排序
 */

public class Heap_Sort {
    private static int heapSize;

    public static void main(String[] args) {
        int[] arr = {4,5,2,8,3,7,1,6,9,4,45,0};

        //基础版
        baseHeapSort(arr);

    }

    private static void baseHeapSort(int[] arr) {
        // 原地建堆
        heapSize = arr.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(arr,i);
        }

        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            ArrayUtil.swap(arr,0, --heapSize);

            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(arr,0);
        }
        ArrayUtil.print(arr);
    }

    private static void siftDown(int[] array, int index) {
        int element = array[index];

        int half = heapSize >> 1;
        while (index < half) { // index必须是非叶子节点
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            int child = array[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if (rightIndex < heapSize &&
                    ArrayUtil.cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点
            if (ArrayUtil.cmp(element, child) >= 0) break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }

}
