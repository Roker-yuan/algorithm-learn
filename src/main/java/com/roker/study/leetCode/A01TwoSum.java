package com.roker.study.leetCode;

import com.roker.study.sort.Quick_Sort;
import com.roker.study.sort.Sort;
import com.roker.study.utils.ArrayUtil;

import java.util.HashMap;

/**
 * @Author Roker
 * @Date 2021/07/07 17:08
 * @Title A01TwoSum
 * @Description
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class A01TwoSum {
    private static Sort sort = new Sort();
    public static void main(String[] args) {
        int[] nums = {2,8,4,5,9,7,11,15};
        int target = 6;
        int[] res;
        //方法一：暴力枚举 Violent enumeration
        System.out.println("===  方法一：暴力枚举  ===");
        res = method1(nums, target);
        ArrayUtil.print(res);

        //方法二：hash
        System.out.println("===  方法二：哈希表  ===");
        res = method2(nums, target);
        ArrayUtil.print(res);

        //方法三：双指针法(改法改变了数组元素位置，不符合题意，适合求目标元素，非索引)
        System.out.println("===  方法三：双指针法  ===");
        res = method3(nums, target);
        ArrayUtil.print(res);

    }

    /**
     * 方法三：双指针法
     * @param nums
     * @param target
     * @return
     */
    private static int[] method3(int[] nums, int target) {
        //利用快排将数组排序
        int[] ints = sort.quickSort(nums);
        ArrayUtil.print(ints);
        //定义指针
        int left = 0;
        int right = ints.length - 1;
        for (int i = 0; i < ints.length; i++) {
            left = i;
            while (left < right){
                if (nums[left] == target - nums[right]){
                    System.out.println("满足条件的数组下标为：" + left + " 和 " + right + "; " +
                            "元素为：" + nums[left]  + "和" +  nums[right] );
                    return new int[]{left,right};
                }
                right--;
            }

        }
        return new int[0];
    }

    private static void quickSort(int[] nums) {

    }

    /**
     * 方法二：哈希表
     * @param nums
     * @param target
     * @return
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     */
    private static int[] method2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                int j = map.get(target - nums[i]);
                System.out.println("满足条件的数组下标为：" + j + " 和 " + i + "; " +
                        "元素为：" + (target - nums[i])  + "和" +  nums[i] );
                return new int[]{j,i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     * 利用两层 for 循环来遍历每个元素，并查找满足条件的目标元素。
     * 时间复杂度为 O(N^2)，空间复杂度为 O(1)
     */
    public static int[] method1(int[] nums, int target) {
        //
        int point;
        for (int i = 0; i < nums.length; i++) {
            point = i+1;
            while (point < nums.length){
                if (target == (nums[i] + nums[point])){
                    System.out.println("满足条件的数组下标为：" + i + " 和 " + point + "; " +
                            "元素为：" + nums[i] + "和" +  nums[point]);
                    return new int[]{i,point};
                }
                point++;
            }
        }
        return new int[0];
    }
}
