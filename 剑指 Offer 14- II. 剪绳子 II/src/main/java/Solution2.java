/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 找规律解法，比动态规划快很多
 *
 * @author wubiao21 2020年07月17日 14:40:54
 */
public class Solution2 {

    private static final int MOD = 1000000007;

    public int cuttingRope(int n) {

        long[] dp = new long[n + 7];//用long防止溢出
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n <= 6) {
            return (int) dp[n];
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3 % MOD;//当n>=7 后， dp[i]=dp[i-3]*3
        }
        return (int) dp[n];
    }
}

    