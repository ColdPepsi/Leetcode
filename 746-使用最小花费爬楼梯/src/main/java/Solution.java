/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：踏上第i个台阶dp[i]有两种选择，从第i-2阶跨2步到达第i阶dp[i-2]+cost[i]
 * 从第i-1阶跨一步到达第i阶，dp[i-1]+cost[i]
 *
 * @author wubiao21 2020年09月16日 11:42:22
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre1 = cost[0], pre2 = cost[1];
        int current;
        for (int i = 2; i < cost.length; i++) {
            current = Math.min(pre1, pre2) + cost[i];
            pre1 = pre2;
            pre2 = current;
        }
        return Math.min(pre1, pre2);//n个台阶，取到达n-1台阶和到达n个台阶的最小值，因为可以直接从第n-1个台阶跨2步，越过第n个台阶
    }
}