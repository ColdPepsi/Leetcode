/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划解法
 *
 * @author wubiao21 2020年07月06日 08:51:32
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[row][col];//dp[i][j]表示到达obstacleGrid[i][j]的方法数
        for (int i = 0; i < col; i++) {//初始化最上面一行
            if (obstacleGrid[0][i] == 1) {//碰到1就退出，后面的全是0，已经不可达
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {//初始化最左边一列
            if (obstacleGrid[i][0] == 1) {//碰到1就退出，后面的全是0，已经不可达
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;//直接不可达
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//动态转移方程，等于上边和左边的方法数总和
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}