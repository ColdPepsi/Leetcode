/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月27日 17:15:03
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] needs = new int[60];//统计t每个字符个数
        int[] windows = new int[60];//窗口字符个数
        int count = 0;//统计t中有几个不同的字符
        for (int i = 0; i < t.length(); i++) {
            if (needs[t.charAt(i) - 'A'] == 0) {
                count++;//计算count
            }
            needs[t.charAt(i) - 'A']++;//计算字符数
        }
        int left = 0, right = 0;//表示滑动窗口[left,right) 左闭右开
        int start = 0, len = Integer.MAX_VALUE;//记录子串起始下标
        int valid = 0;//计数窗口中有几个字符已经满足要求
        while (right < s.length()) {
            char c = s.charAt(right++);
            int indexC = c - 'A';
            if (needs[indexC] > 0) {//如果目标字符串中包含此字符
                windows[indexC]++;//滑动窗口中该字符计数++；
                if (windows[indexC] == needs[indexC]) {
                    valid++;//窗口内的该字符数满足要求了，更新valid
                }
            }
            while (valid == count) {//包含所有目标字符串中的字符后，开始收缩窗口，left尝试++；这是求解最优解的过程
                if (right - left < len) {//更新最优解
                    len = right - left;
                    start = left;
                }
                char aChar = s.charAt(left++);//left++
                int indexAChar = aChar - 'A';
                if (needs[indexAChar] > 0) {//如果目标串中包含刚移出的字符
                    if (windows[indexAChar] == needs[indexAChar]) {//如果窗口中该字符数因为刚刚等于需要的字符总数，因为要移出了，所以valid--；
                        valid--;
                    }
                    windows[indexAChar]--;//计数--；
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}