package com.roker.study.sort;


import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2020/11/13 16:16
 * @Title Bubble_Sort
 * @Description 冒泡排序
 */

public class Bubble_Sort {

    public static void main(String[] args) {
        int[] arr = {4,5,2,8,3,7,1,6,9,4,45,0};
        bubbleSort(arr);
    }

    //N个数字冒泡排序，总共要进行N-1趟比较，每趟的排序次数为(N-i)次比较
    private static void bubbleSort(int[] arr) {
        // 边界条件判断(注：细节问题，安全编码)
        if (arr==null || arr.length<2) return;

        // N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次
        // 外层 i 控制循环多少趟，内层 j 控制每一趟的循环次数
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        ArrayUtil.print(arr);
    }
}
