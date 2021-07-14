package com.roker.study.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Roker
 * @Date 2021/07/12 10:53
 * @Title A03LongestSubstringWithoutRepeatingCharacters
 * @Description
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class A03LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "cskanab";
        //滑动窗口
        int count = method01(str);
        System.out.println(count);
    }

    /**
     * @param str
     * @return
     * 时间复杂度：O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     *
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 表示字符集（即字符串中可以出现的字符），
     * |\Sigma|∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，
     * 因此可以默认为所有 ASCII 码在 [0, 128)[0,128) 内的字符，
     * 即 |\Sigma| = 128∣Σ∣=128。
     * 我们需要用到哈希集合来存储出现过的字符，
     * 而字符最多有 |\Sigma|∣Σ∣ 个，因此空间复杂度为 O(|\Sigma|)O(∣Σ∣)
     */
    private static int method01(String str) {
        if (str.length()==0) return 0;
        //采用hash集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int len = str.length();//字符串长度，循环使用
        int maxRes = 0;
        //指针 右指针（左指针为遍历指针）
        int right = -1;
        //每次遍历求出以当前位置从左往右，第一次出现重复字符时的长度。然后和记录值maxRes比较和交换
        for (int i = 0; i < len; i++) {
            //左指针每移动一位，在set集合中就移出移动前的字符
            if (i > 0) {
                set.remove(str.charAt(i - 1));
            }
            while (right + 1 < len && !set.contains(str.charAt(right + 1))){
                set.add(str.charAt(right + 1));
                ++right;
            };
            maxRes = Math.max(maxRes, right + 1 - i);

        }
        return maxRes;

    }
}
