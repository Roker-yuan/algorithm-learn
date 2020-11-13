package com.roker.study.utils;

/**
 * @Author Roker
 * @Date 2020/11/13 17:23
 * @Title ArrayUtil
 * @Description 数组工具类
 */

public class ArrayUtil {
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
}
