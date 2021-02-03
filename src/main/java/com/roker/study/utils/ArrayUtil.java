package com.roker.study.utils;

/**
 * @Author Roker
 * @Date 2020/11/13 17:23
 * @Title ArrayUtil
 * @Description 数组工具类
 */

public class ArrayUtil {


    /**
     * 输出数组
     * @param arr
     */
    public static void print(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i == arr.length - 1){
                sb.append("]");
                break;
            }
            sb.append(",");
        }
        System.out.println("结果打印：" + sb);
    }

    /**
     * 数组索引为a,b位置的值交换位置
     * @param arr
     * @param a
     * @param b
     * @return
     */
    public static int[] swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return arr;
    }

    /**
     * 比较数组arr中索引i1和i2对应值大小，返回其差值
     * @param arr
     * @param i1
     * @param i2
     * @return
     */
    public static int cmp(int[] arr, int i1, int i2) {
        return (arr[i1] - arr[i2]) ;
    }

    /**
     * 比较元素v1和v2对应值大小，返回其差值
     * @param v1
     * @param v2
     * @return
     */
    public static int cmp(int v1, int v2) {
        return (v1 - v2);
    }

}
