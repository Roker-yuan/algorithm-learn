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

        //基础版
        bubbleSort(arr);

        //优化-1-如果序列已经完全有序，可以提前终止冒泡排序
        bubbleSortOptimization1(arr);

        //优化-2-如果序列尾部已经局部有序，可以记录最后1次交换的位置，减少比较次数
        bubbleSortOptimization2(arr);
    }


    //N个数字冒泡排序，总共要进行N-1趟比较，每趟的排序次数为(N-i)次比较
    private static void bubbleSort(int[] arr) {
        // 边界条件判断(注：细节问题，安全编码)
        if (arr==null || arr.length<2) return;

        // N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次
        // 外层 i 控制循环多少趟，内层 j 控制每一趟的循环次数

        /*版本一*/
//        for (int i = 1; i < arr.length; i++){
//            for (int j = 0; j < arr.length - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
        /*版本二*/
        for (int end = arr.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end ; begin++) {
                if (arr[begin] < arr[begin - 1]){
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = tmp;
                }
            }
        }
        ArrayUtil.print(arr);

    }

    private static void bubbleSortOptimization1(int[] arr) {
        // 边界条件判断(注：细节问题，安全编码)
        if (arr==null || arr.length<2) return;

        // **优化点**  引入标记值flag 如果在某一次内循环排序比较时，未发生位置交换，说明排序已经完成，无序排序，则提前break 终止循环
        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = true;
            for (int begin = 1; begin <= end ; begin++) {
                if (arr[begin] < arr[begin - 1]){
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        ArrayUtil.print(arr);
    }

    private static void bubbleSortOptimization2(int[] arr) {
        //边界条件判断（注：细节问题，安全编码）
        if (arr == null || arr.length < 2) return;

        // **优化点** 引入位置标记值swagIndex，记录某次循环最后1次交换的位置，如果序列尾部已经局部有序，减少比较次数
        for (int end = arr.length - 1; end > 0; end--) {

            int swagIndex = 1;//此处数值的确定只要小于等于1即可
            for (int begin = 1; begin <= end ; begin++) {
                if (arr[begin] < arr[begin - 1]){
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = tmp;
                    swagIndex = begin;
                }
            }
            end = swagIndex;

        }
        ArrayUtil.print(arr);
    }


}
