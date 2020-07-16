/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：dfs解法，不是回溯
 *
 * @author wubiao21 2020年07月15日 11:46:55
 */
public class Solution2 {
    public String getPermutation(int n, int k) {
        return dfs(0, new char[n], n, k, new boolean[n]);
    }

    /**
     * dfs搜索
     *
     * @param index      当前要处理的下标
     * @param prefix     已经保存的前缀
     * @param n          参数n
     * @param k          参数k
     * @param hasVisited 记录某个数有没有被访问
     * @return 返回第k个排列
     */
    private String dfs(int index, char[] prefix, int n, int k, boolean[] hasVisited) {
        if (index == n) {
            return new String(prefix);//记录结果
        }
        int count = factorial(n - 1 - index);//index后有几种选择
        for (int i = 1; i <= n; i++) {
            if (hasVisited[i - 1]) {//hasVisited下标从0~n-1，所以偏移一位
                continue;
            }
            if (k > count) {
                k -= count;//看看跳过几位
                continue;
            }
            prefix[index] = (char) (i + '0');//加入前缀
            hasVisited[i - 1] = true;//标记为已经访问
            return dfs(index + 1, prefix, n, k, hasVisited);
        }
        return null;
    }

    /**
     * 返回n的阶乘
     */
    private int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
}