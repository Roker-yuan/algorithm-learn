package com.roker.study.leetCode;

/**
 * @Author Roker
 * @Date 2021/07/13 10:44
 * @Title A05LongestPalindrome
 * @Description
 * 给你一个字符串 s，找到 s 中最长的回文子串。   
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class A05LongestPalindrome {
    public static void main(String[] args) {
        String test = "asdfgfdhjk";

        String res = null;
        //方法1：中心扩散法：
        res = method1(test);
        System.out.println(res);
    }

    /**
     * 方法1：中心扩散法：
     * @param str
     * @return
     */
    private static String method1(String str) {
        //判断字符串的合法性
        if (str.length() < 1 || str == null) return "";
        //初始化最大回文子串的起点和终点
        int start = 0;
        int end = 0;
        //遍历每个位置，当做中心位置
        for (int i = 0; i < str.length(); i++) {
            //分别拿到奇数和偶数的回文子串长度
            int len_odd = expandCenter(str,i,i);
            int len_even = expandCenter(str,i,i+1);
            //对比最大的长度
            int len = Math.max(len_even,len_odd);
            //计算对应最大回文子串的起点和终点
            if (len > end - start){
                start = i - (len -1)/2;
                end = i + len /2;
            }
        }
        //注意：这里的end+1是因为java自带的左闭右开的原因
        return str.substring(start,end+1);

    }

    private static int expandCenter(String str, int left, int right) {
        //当left = fight 的时候，此时回文中心是一个字符，回文串的长度是个奇数
        //当right = left - 1的时候，此时回文中心是一个空隙，回文串的长度是个偶数
        //跳出循环的时候恰好满足 str.charAt(left) != str.charAt(right)
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        //回文串的长度是 right - left + 1 -2 = right - left - 1
        return right - left - -1;
    }
}

