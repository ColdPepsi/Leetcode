/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：主站第3题
 *
 * @author wubiao21 2020年07月28日 19:37:18
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int ret = 0;
        int[] windows = new int[128];
        while (right < s.length()) {
            char aChar = chars[right++];
            windows[aChar]++;
            while (windows[aChar] > 1) {
                char c = chars[left++];
                windows[c]--;
            }
            ret = Math.max(ret, right - left);
        }
        return ret;
    }
}