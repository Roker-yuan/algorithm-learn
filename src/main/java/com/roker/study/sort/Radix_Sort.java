package com.roker.study.sort;

public class Radix_Sort extends Sort {

	public static void main(String[] args) {
		RadixSort();
	}

	protected static void RadixSort() {
		// 找出最大值
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		// 个位数: arr[i] / 1 % 10 = 3
		// 十位数：arr[i] / 10 % 10 = 9
		// 百位数：arr[i] / 100 % 10 = 5
		// 千位数：arr[i] / 1000 % 10 = ...

		for (int divider = 1; divider <= max; divider *= 10) {
			countingSort(divider);
		}
	}
	
	protected static void countingSort(int divider) {
		// 开辟内存空间，存储次数
		int[] counts = new int[10];
		// 统计每个整数出现的次数
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i] / divider % 10]++;
		}
		// 累加次数
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		
		// 从后往前遍历元素，将它放到有序数组中的合适位置
		int[] newarr = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			newarr[--counts[arr[i] / divider % 10]] = arr[i];
		}
		
		// 将有序数组赋值到arr
		for (int i = 0; i < newarr.length; i++) {
			arr[i] = newarr[i];
		}
	}
}
