/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 递归解法
 *
 * @author wubiao21 2020年07月23日 13:58:30
 */
public class Solution2 {

    private int[][] matrix;
    private int rows;
    private int cols;
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        matrix = grid;
        rows = grid.length;
        cols = grid[0].length;
        memo = new int[rows][cols];
        return dfs(0, 0);
    }

    /**
     * dfs(row,col)返回 grid[row][col]到右下的最小路径和
     *
     * @param row
     * @param col
     * @return
     */
    private int dfs(int row, int col) {
        if (row == rows - 1 && col == cols - 1) {
            return matrix[row][col];
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int res = 0;
        if (row == rows - 1) {
            res = dfs(row, col + 1);
        } else if (col == cols - 1) {
            res = dfs(row + 1, col);
        } else {
            res = Math.min(dfs(row + 1, col), dfs(row, col + 1));
        }
        res += matrix[row][col];
        memo[row][col] = res;
        return res;
    }
}