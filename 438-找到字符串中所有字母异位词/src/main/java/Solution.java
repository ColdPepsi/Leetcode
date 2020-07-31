/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：滑动窗口，详细注释在76题
 *
 * @author wubiao21 2020年07月28日 18:28:16
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>(s.length() / p.length());
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        int[] needs = new int[26];
        int[] windows = new int[26];
        int differentLetterCount = 0;
        for (char c : charsP) {
            int index = c - 'a';
            if (needs[index] == 0) {
                differentLetterCount++;
            }
            needs[index]++;
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < charsS.length) {
            int index1 = charsS[right++] - 'a';
            if (needs[index1] > 0) {
                windows[index1]++;
                if (windows[index1] == needs[index1]) {
                    valid++;
                }
            }
            while (valid == differentLetterCount) {
                if (right - left == charsP.length) {
                    ret.add(left);
                }
                int index2 = charsS[left++] - 'a';
                if (needs[index2] > 0) {
                    if (windows[index2] == needs[index2]) {
                        valid--;
                    }
                    windows[index2]--;
                }
            }
        }
        return ret;
    }
}