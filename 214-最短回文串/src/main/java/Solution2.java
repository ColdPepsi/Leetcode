/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：字符串哈希
 *
 * @author wubiao21 2020年09月01日 11:08:02
 */
public class Solution2 {

    private static final int base = 131;
    private static final int mod = (int) (1E9) + 7;

    public String shortestPalindrome(String s) {
        int power = 1;
        int index = -1;
        int leftToRight = 0;
        int rightToLeft = 0;
        //用字符串哈希来找从0开始的最长回文
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            leftToRight = (int) (((long) c * power + leftToRight) % mod);//相当于新加入的数字是最高位
            rightToLeft = (int) (((long) rightToLeft * base + c) % mod);//相当于新加入的数字是最低位
            if (leftToRight == rightToLeft) {
                index = i;//记录最长子串下标
            }
            power = (int) ((long) power * base % mod);
        }
        StringBuilder ret = new StringBuilder(2 * s.length());
        for (int i = s.length() - 1; i > index; i--) {
            ret.append(s.charAt(i));
        }
        return ret.append(s).toString();
    }
}