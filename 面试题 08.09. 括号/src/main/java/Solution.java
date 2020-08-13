/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：直接暴力回溯
 *
 * @author wubiao21 2020年08月12日 10:29:50
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(n * n);
        if (n != 0) {
            backTracking(0, 0, n, res, new StringBuilder());
        }
        return res;
    }

    /**
     * 回溯法
     *
     * @param totalLeft  当前的左括号数
     * @param totalRight 当前的右括号数
     * @param n          括号对数
     * @param res        结果集
     * @param prefix     前缀
     */
    private void backTracking(int totalLeft, int totalRight, int n, List<String> res, StringBuilder prefix) {
        if (prefix.length() == 2 * n) {//找到结果，保存到结果集
            res.add(prefix.toString());
            return;
        }
        if (totalLeft < n) {//尝试加入左括号
            prefix.append('(');
            backTracking(totalLeft + 1, totalRight, n, res, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        if (totalRight < totalLeft) {//右括号数不能超过左括号，尝试加入右括号
            prefix.append(')');
            backTracking(totalLeft, totalRight + 1, n, res, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}