/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：滑动窗口，滑动窗口详细注释在76题
 *
 * @author wubiao21 2020年07月28日 18:53:02
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] windows = new int[128];
        int left = 0, right = 0;
        int ret = 0;
        while (right < chars.length) {
            char aChar = chars[right++];
            windows[aChar]++;//更新窗口内字符计数值
            while (windows[aChar] > 1) {//如果大于1,说明出现重复字符
                char c = chars[left++];
                windows[c]--;//更新窗口计数值
            }
            ret = Math.max(ret, right - left);//结果值
        }
        return ret;
    }
}