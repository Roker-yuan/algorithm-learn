package com.roker.study.sort;


import com.roker.study.utils.ArrayUtil;

/**
 * @Author Roker
 * @Date 2021/02/22 18:18
 * @Title Quick_Sort
 * @Description 快速排序
 */

public class Quick_Sort extends Sort {

/**
 ① 从序列中选择一个轴点元素（pivot） ✓ 假设每次选择 0 位置的元素为轴点元素
② 利用 pivot 将序列分割成 2 个子序列
✓ 将小于 pivot 的元素放在pivot前面（左侧）
✓ 将大于 pivot 的元素放在pivot后面（右侧）
✓ 等于pivot的元素放哪边都可以
③ 对子序列进行 ① ② 操作
✓ 直到不能再分割（子序列中只剩下1个元素）*/

    public static void main(String[] args) {
        ArrayUtil.print(arr);
        sort(0,arr.length);
        ArrayUtil.print(arr);

    }
    public static void sort(int begin, int end){
        //排序数组合法性校验
        if ((end - begin) < 2) return ;

        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private static int pivotIndex(int begin, int end) {
        //选取索引为0即数组的第一个元素作为轴点 pivot
        //备份轴点元素
        int pivot = arr[begin];
        // end指向最后一个元素
        end--;

        while(begin < end){
            //将小于 pivot 的元素放在pivot前面（左侧）
            while(begin < end){
                if (pivot < arr[end]){
                    end--;
                }else{
                    arr[begin++] = arr[end];
                    break;
                }
            }
            //将大于 pivot 的元素放在pivot后面（右侧）
            while(begin < end){
                if (arr[begin] < pivot){
                    begin++;
                }else{
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }
        //将pivot放在基准位置
        arr[begin] = pivot;
        return begin;
    }


}
