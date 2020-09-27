/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：排序+二分
 *
 * @author wubiao21 2020年09月16日 16:53:08
 */
public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[ ] profit, int[] worker) {
        int len = difficulty.length;
        int[][] jobs = new int[len][3];
        for (int i = 0; i < len; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];//jobs[i][2]存放小于等于难度jobs[i][0]的最大收益
        }
        Arrays.sort(jobs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int maxProfit = -1;
        //预处理，来更新最大收益
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, jobs[i][1]);
            jobs[i][2] = maxProfit;
        }
        int total = 0;
        for (int skill : worker) {
            if (skill < jobs[0][0]) {//不足以完成最简单的工作
                continue;
            }
            if (skill >= jobs[len - 1][0]) {
                total += jobs[len - 1][2];//如果超过最大难度，直接去最大收益
            } else {
                //下面开始二分查找，找到最接近skill且第一个小于等于skill的难度
                int left = 0, right = len - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (jobs[mid][0] > skill) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                //退出循环时候，left==right,jobs[left][0]难度为第一个大于skill的难度，则jobs[left-1][0]为最接近skill且小于等于skill的难度
                total += jobs[left - 1][2];
            }
        }
        return total;
    }
}
    