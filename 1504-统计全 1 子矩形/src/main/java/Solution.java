/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划
 *
 * @author wubiao21 2020年08月28日 13:40:15
 */
public class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];//dp[i][j]表示本行以mat[i][j]为终点的最大1*n的矩形数
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int col = dp[i][j];
                for (int k = i; k >= 0 && col != 0; k--) {//对于每个元素我们从下网上数，就是以mat[i][j]为矩阵右下角，矩阵长为i-k+1，宽为col的矩阵数
                    col = Math.min(col, dp[k][j]);
                    ans += col;
                }
            }
        }
        return ans;
    }
}