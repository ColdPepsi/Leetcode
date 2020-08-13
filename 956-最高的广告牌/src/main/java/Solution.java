/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：8月8号的网易互联网笔试题第三题，拆分礼物
 * 暴力回溯法，会超时，需要剪枝
 *
 * @author wubiao21 2020年08月10日 09:32:32
 */
public class Solution {

    private int res = Integer.MIN_VALUE;

    public int tallestBillboard(int[] rods) {
        if (rods.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        Arrays.sort(rods);//rods要降序排序
        for (int i = 0, j = rods.length - 1; i < j; i++, j--) {
            int temp = rods[i];
            rods[i] = rods[j];
            rods[j] = temp;
        }
        dfs(0, 0, 0, rods, sum);
        return res;
    }

    /**
     * 回溯尝试每种分配可能，每根铁棒都可以有3种选择，给长度1，给长度2，都不选
     *
     * @param index  当前应该处理的下标
     * @param len1   长度1
     * @param len2   长度2
     * @param rods   铁棒数组
     * @param remain 剩下的铁棒长度
     */
    private void dfs(int index, int len1, int len2, int[] rods, int remain) {
        if (index == rods.length) {//所有铁棒已经分配完毕
            if (len1 == len2) {//如果两个长度相等，记录最佳结果
                res = Math.max(res, len1);
            }
            return;
        }
        if (Math.abs(len1 - len2) > remain || len1 + len2 + remain <= res * 2) {
            //剪枝，如果把remain全分给其中一个也对不齐了，如果吧remain全部分配也得不到最优解了，就剪枝
            return;
        }
        remain -= rods[index];
        dfs(index + 1, len1 + rods[index], len2, rods, remain);//进行下一轮分配，当前的铁棒分配给长度1
        dfs(index + 1, len1, len2 + rods[index], rods, remain);//进行下一轮分配，当前的铁棒分配给长度2
        dfs(index + 1, len1, len2, rods, remain);//进行下一轮分配，当前的铁棒丢弃
    }
}