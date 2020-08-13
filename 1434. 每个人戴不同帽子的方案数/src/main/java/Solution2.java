/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubiao21 2020年08月10日 19:42:28
 */
public class Solution2 {

    private static final int MOD = (int) (1E9) + 7;

    public int numberWays(List<List<Integer>> hats) {
        int personCount = hats.size();//记录有多少人
        List<Integer>[] hatToPerson = new List[41];
        for (int i = 0; i < personCount; i++) {//建立帽子到人映射 hatToPerson[i]表示喜欢帽子i的人列表
            for (Integer hat : hats.get(i)) {
                if (hatToPerson[hat] == null) {
                    hatToPerson[hat] = new ArrayList<>();
                }
                hatToPerson[hat].add(i);
            }
        }
        int allMarked = (1 << personCount) - 1;//加括号
        int marked = 0;
        Integer[][] dp = new Integer[41][allMarked + 1];
        return dfs(1, hatToPerson, marked, allMarked, dp);
    }

    /**
     * 返回从index开始到末尾的分配数
     *
     * @param index       起始帽子编号
     * @param hatToPerson 帽子到人的映射
     * @param marked      第i位表示第i个人有没有分配。从左往右数
     * @param allMarked   表示所有人都已经分配
     * @param dp          缓存
     * @return
     */
    private int dfs(int index, List<Integer>[] hatToPerson, int marked, int allMarked, Integer[][] dp) {
        if (index == 41) {
            return allMarked == marked ? 1 : 0;
        }
        if (dp[index][marked] != null) {
            return dp[index][marked];
        }
        int res = 0;
        res += dfs(index + 1, hatToPerson, marked, allMarked, dp);
        if (hatToPerson[index] == null) {
            return res;
        }
        for (Integer person : hatToPerson[index]) {
            if (((marked >> person) & 1) == 1) {
                continue;
            }
            res += dfs(index + 1, hatToPerson, marked | (1 << person), allMarked, dp);
            res %= MOD;
        }
        dp[index][marked] = res;
        return res;
    }
}