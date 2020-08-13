/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.List;

/**
 * 类Solution.java的实现描述：回溯解法，尝试给每个人分配所有可能的帽子
 *
 * @author wubiao21 2020年08月03日 11:08:14
 */
public class Solution {

    private static final int MOD = (int) (1E9) + 7;
    private int res = 0;
    private List<List<Integer>> hats;

    public int numberWays(List<List<Integer>> hats) {
        int personCount = hats.size();//记录有多少人
        boolean[] used = new boolean[41];
        this.hats = hats;
        backTracking(0, used, personCount);
        return res;
    }

    private void backTracking(int index, boolean[] used, int personCount) {
        if (index == personCount) {
            res++;//找到结果
            res %= MOD;
            return;
        }
        for (Integer hat : hats.get(index)) {
            if (used[hat]) {
                continue;
            }
            used[hat] = true;
            backTracking(index + 1, used, personCount);
            used[hat] = false;
        }
    }
}