/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划
 *
 * @author wubiao21 2020年09月10日 09:38:03
 */
public class Solution {
    public int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] dp = new int[rows][cols];//dp[i][j]表示从A[i][j]出发，下降路径最小和
        for (int i = 0; i < cols; i++) {
            dp[rows - 1][i] = A[rows - 1][i];
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                //自己下面这列和下面左右两列取最低
                int min = dp[i + 1][j];
                if (j >= 1) {
                    min = Math.min(min, dp[i + 1][j - 1]);
                }
                if (j <= cols - 2) {
                    min = Math.min(min, dp[i + 1][j + 1]);
                }
                dp[i][j] = min + A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            res = Math.min(res, dp[0][i]);
        }
        return res;
    }
}