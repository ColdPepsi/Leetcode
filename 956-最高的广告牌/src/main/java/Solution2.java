/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：动态规划解法
 *
 * @author wubiao21 2020年08月10日 17:39:40
 */
public class Solution2 {
    public int tallestBillboard(int[] rods) {
        if (rods.length < 2) {
            return 0;
        }
        int sum = 0;
        int n = rods.length;
        for (int rod : rods) {
            sum += rod;//计算所有杆的总长
        }
        int[][] dp = new int[n][sum + 1];//dp[i][j]表示前i+1根钢筋，形成的两个子集差为j的最大子集和
        dp[0][rods[0]] = rods[0];//在只用第一根钢筋的情况下，能够形成的差为rods[0]的两个子集和，他们的最大和为rods[0]，因为rods[0]+0==rods[0]
        int preSum = rods[0];//前缀和，目前用了钢筋的总和
        for (int i = 1; i < n; i++) {//第二根开始处理
            for (int j = 0; j <= preSum; j++) {//j的范围是[0,preSum]
                if (dp[i - 1][j] < j) {
                    //如果两个子集的差为j,他们的和肯定大于j，所以如果小于j说明是非法值，直接跳过
                    continue;
                }
                //rods[i]丢弃不用
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                //rods[i]放入高的子集，两个子集的差会更大
                int k = j + rods[i];//现在的两个子集的差
                dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rods[i]);
                //rods[i]放入较低的子集
                k = Math.abs(j - rods[i]);//现在的两个子集的差
                dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rods[i]);
            }
            preSum += rods[i];
        }
        return dp[n - 1][0] / 2;
    }
}