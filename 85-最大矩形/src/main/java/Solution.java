/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：动态规划
 *
 * @author wubiao21 2020年09月02日 10:36:20
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';//注意matrix矩阵的内容为字符
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i][j - 1] + 1;//dp[i][j]表示matrix[i][j]在本行向左延伸最远的1的长度
                }
            }
        }
        int max = 0;//记录结果
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (max >= (i + 1) * (j + 1)) {//剪枝
                    break;
                }
                if (dp[i][j] >= 1) {
                    int width = dp[i][j];//记录矩形的宽
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);//k从本行出发，向上取最小的dp[i][j]作为矩形的宽
                        max = Math.max(max, width * (i - k + 1));//(i - k + 1)是矩形的高
                    }
                }
            }
        }
        return max;
    }
}