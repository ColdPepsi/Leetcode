/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wubiao21 2020年07月21日 09:32:46
 */
public class Solution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>(factorial(chars.length));
        Arrays.sort(chars);
        backTracking(res, new StringBuilder(), chars, new boolean[chars.length]);
        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private void backTracking(List<String> res, StringBuilder prefix, char[] chars, boolean[] hasVisited) {
        if (prefix.length() == chars.length) {
            res.add(prefix.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i - 1] == chars[i] && !hasVisited[i - 1]) {
                continue;
            }
            if (!hasVisited[i]) {
                hasVisited[i] = true;
                prefix.append(chars[i]);
                backTracking(res, prefix, chars, hasVisited);
                prefix.deleteCharAt(prefix.length() - 1);
                hasVisited[i] = false;
            }
        }
    }

    private int factorial(int x) {
        return x == 0 || x == 1 ? 1 : x * factorial(x - 1);
    }
}