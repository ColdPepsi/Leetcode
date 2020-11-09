/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：双指针
 *
 * @author wubiao21 2020年10月21日 09:38:29
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] s = name.toCharArray();
        char[] t = typed.toCharArray();
        int i = 0, j = 0;
        while (j < t.length) {
            if (i < s.length && s[i] == t[j]) {//两字符相等 指针都++
                i++;
                j++;
            } else if (j > 0 && t[j] == t[j - 1]) {//当字符不相等，判断t是否出现了重复字符，出现重复字符则j++；
                j++;
            } else {//其他情况返回false
                return false;
            }
        }
        return i == s.length;
    }
}