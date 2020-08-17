/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划
 *
 * @author wubiao21 2020年08月13日 15:59:59
 */
public class Solution {

    private static final int[] coins = {1, 5, 10, 25};
    private static final int MOD = 1000000007;

    public int waysToChange(int n) {
        if (n < 5) {
            return 1;
        }
        int[][] dp = new int[5][n + 1];//dp[i][j]表示用前i种硬币，组成面值j的方案总数
        //dp[0][j]==0; 0种硬币组任何面值的方案数都是0
        for (int i = 1; i < 5; i++) {
            dp[i][0] = 1;//组成面值0的方案只有1种，就是什么也不取
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];//dp[i - 1][j]表示当前硬币不选
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];//dp[i][j-coins[i]]表示选择当前硬币，还需要组成j-coins[i]面值
                }
                dp[i][j] %= MOD;
            }
        }
        return dp[4][n];
    }
}