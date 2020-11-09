/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：双指针
 *
 * @author wubiao21 2020年10月19日 10:02:53
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int i = arrange(s);
        int j = arrange(t);
        if (i != j) {
            return false;
        } else {
            for (int k = 0; k < i; k++) {
                if (s[k] != t[k]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 重新整理字符串，把字符串整理到[0,slow)
     *
     * @param chars
     * @return
     */
    private int arrange(char[] chars) {
        int slow = 0, fast = 0;
        while (fast < chars.length) {
            if (chars[fast] != '#') {
                chars[slow++] = chars[fast];
            } else {
                if (slow <= 0) {
                    slow = 0;
                } else {
                    slow--;
                }
            }
            fast++;
        }
        return slow;
    }
}