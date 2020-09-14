/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：记忆化递归
 *
 * @author wubiao21 2020年09月10日 08:35:45
 */
public class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] grid;
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        grid = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] memo = new int[rows][cols];//memo[i][j]表示以matrix[i][j]为起点的最长递增链
        int res = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dfs(i, j, memo));
            }
        }
        return res;
    }

    /**
     * dp（i,j）表示以matrix[i][j]为起点的最长递增链
     *
     * @param row
     * @param col
     * @param memo
     * @return
     */
    private int dfs(int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int step = 1;//初始化1，表示自身
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (inArea(nextRow, nextCol) && grid[row][col] > grid[nextRow][nextCol]) {
                step = Math.max(step, dfs(nextRow, nextCol, memo) + 1);//取四周最长的一条链
            }
        }
        memo[row][col] = step;
        return step;//返回结果，如果没进入循环，memo[row][col]就是1，表示自身自己
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}