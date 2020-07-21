/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月20日 11:49:42
 */
public class Solution {

    private int[][] memo;//缓存，防止重复计算
    private int rows;//行数
    private int cols;//列数
    private int[][] grid;

    public int maxValue(int[][] grid) {
        this.grid = grid;//初始化
        rows = grid.length;
        cols = grid[0].length;
        memo = new int[rows][cols];
        return dfs(0, 0);
    }

    /**
     * dfs(i,j)表示从grid[i][j]出发到终点所能取得的最大值
     *
     * @param row 横坐标
     * @param col 纵坐标
     * @return
     */
    private int dfs(int row, int col) {
        if (row == rows - 1 && col == cols - 1) {//抵达终点，直接返回
            return grid[row][col];
        }
        if (memo[row][col] != 0) {//已经计算过，返回结果
            return memo[row][col];
        }
        int max = 0;
        if (row == rows - 1) {//最后一行，向右递归
            max = dfs(row, col + 1);
        } else if (col == cols - 1) {//最后一列向下递归
            max = dfs(row + 1, col);
        } else {//取自己右边或者下边的最大值
            max = Math.max(dfs(row, col + 1), dfs(row + 1, col));
        }
        max += grid[row][col];//加上自己的值
        memo[row][col] = max;//存入缓存
        return max;
    }
}