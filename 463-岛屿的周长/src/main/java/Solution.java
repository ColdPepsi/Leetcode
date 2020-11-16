/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：dfs，如果一条边临水域或者是网格的边界，才计算在周长内
 *
 * @author wubiao21 2020年11月10日 11:08:59
 */
class Solution {
    private int[][] matrix;
    private int rows;
    private int cols;
    private int res;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        res = 0;
        matrix = grid;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dfs(i, j);
                    break;
                }
            }
        }
        return res;
    }

    private void dfs(int row, int col) {
        matrix[row][col] = -1;//标记已访问
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (outOfArea(nextRow, nextCol) || matrix[nextRow][nextCol] == 0) {
                res++;//出界临水域边界++
            } else if (matrix[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol);
            }
        }
    }

    private boolean outOfArea(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }
}
    