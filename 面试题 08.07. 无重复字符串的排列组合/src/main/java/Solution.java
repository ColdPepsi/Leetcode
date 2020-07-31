/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubiao21 2020年07月30日 17:43:52
 */
public class Solution {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>(factorial(S.length()));
        backTracking(new StringBuilder(), res, new boolean[S.length()], S);
        String[] ret = new String[res.size()];
        int index = 0;
        for (String str : res) {
            ret[index++] = str;
        }
        return ret;
    }

    /**
     * 常规回溯解法
     *
     * @param prefix     记录前缀
     * @param res        结果集
     * @param hasVisited 标记某个字符有没有被访问
     * @param s          字符串s
     */
    private void backTracking(StringBuilder prefix, List<String> res, boolean[] hasVisited, String s) {
        if (prefix.length() == s.length()) {
            res.add(prefix.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            prefix.append(s.charAt(i));
            backTracking(prefix, res, hasVisited, s);
            prefix.deleteCharAt(prefix.length() - 1);
            hasVisited[i] = false;
        }
    }

    /**
     * 计算x的阶乘
     *
     * @param x
     * @return
     */
    private int factorial(int x) {
        return x == 0 || x == 1 ? 1 : x * factorial(x - 1);
    }
}