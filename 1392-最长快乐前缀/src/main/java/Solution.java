/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月09日 09:15:49
 */
public class Solution {
    /**
     * 字符串哈希
     *
     * @param s
     * @return
     */
    public String longestPrefix(String s) {
        long prefix = 0;//前缀哈希值
        long suffix = 0;//后缀哈希值
        int base = 31;//基数
        int mod = 1000000007;
        int happy = -1;//快乐前缀下标，s长度为1时候，不会进入循环，所以初值设置为-1
        long product = 1;//当前位的权值
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            prefix = (prefix * base + (s.charAt(i) - 'a')) % mod;//前缀是在最后扩充一位，所以prefix乘以基数再加上新扩充的数
            suffix = ((s.charAt(len - 1 - i) - 'a') * product + suffix) % mod;//后缀是在最前面扩充一位，所以新扩充的数乘以权值再加上原来的后缀
            if (prefix == suffix) {
                happy = i;
            }
            product = (product * base) % mod;
        }
        return s.substring(0, happy + 1);
    }
}