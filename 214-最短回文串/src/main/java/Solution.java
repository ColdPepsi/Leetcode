/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述:暴力解法
 * 找到字符串s从下标0开始的最长的回文串，然后把s剩下的部分翻转加到s的头部就是最后的结果
 *
 * @author wubiao21 2020年08月31日 19:58:15
 */
public class Solution {

    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (palindrome(chars, i)) {//找到chars从下标0开始的最长的回文串，回文串的右下标记做i
                StringBuilder ret = new StringBuilder(2 * chars.length);
                for (int j = chars.length - 1; j > i; j--) {//把s剩下的部分翻转拼接到结果的最前面
                    ret.append(chars[j]);
                }
                return ret.append(s).toString();
            }
        }
        return "";
    }

    /**
     * 判断chars[0,right]是否是回文
     *
     * @param chars
     * @param right
     * @return
     */
    private boolean palindrome(char[] chars, int right) {
        int left = 0;
        while (right > left) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}