/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类Solution.java的实现描述：暴力求解
 *
 * @author wubiao21 2020年08月06日 15:44:15
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && palindrome(words[i] + words[j])) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private boolean palindrome(String word) {
        if (word == null || word.length() < 2) {
            return true;
        }
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}