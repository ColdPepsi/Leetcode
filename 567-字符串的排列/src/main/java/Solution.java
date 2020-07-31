/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：滑动窗口，滑动窗口的详细注释在第76题
 *
 * @author wubiao21 2020年07月28日 16:13:13
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] needs = new int[26];
        int[] windows = new int[26];
        int differentLetterCount = 0;
        for (char c : chars1) {//计数
            int index = c - 'a';
            if (needs[index] == 0) {
                differentLetterCount++;
            }
            needs[index]++;
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < chars2.length) {
            char c = chars2[right++];
            int indexC = c - 'a';
            if (needs[indexC] > 0) {
                windows[indexC]++;
                if (windows[indexC] == needs[indexC]) {
                    valid++;
                }
            }
            while (valid == differentLetterCount) {
                if (right - left == chars1.length) {//如果窗口内的长度正好是s1的长度，说明找到了子串
                    return true;
                }
                char aChar = chars2[left++];
                int indexAChar = aChar - 'a';
                if (needs[indexAChar] > 0) {
                    if (windows[indexAChar] == needs[indexAChar]) {
                        valid--;
                    }
                    windows[indexAChar]--;
                }
            }
        }
        return false;
    }
}