/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月24日 09:42:27
 */
public class Solution2 {

    private int rows;
    private int cols;
    private int k;
    boolean[][] hasVisited;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        rows = m;
        cols = n;
        this.k = k;
        hasVisited = new boolean[rows][cols];
        return dfs(0, 0, 0, 0);
    }

    /**
     * 计算从（row,col）出发可以访问的格子数
     *
     * @param row    横坐标
     * @param col    纵坐标
     * @param sumRow 横坐标数位和
     * @param SumCol 纵坐标数位和
     * @return
     */
    private int dfs(int row, int col, int sumRow, int SumCol) {
        if (outArea(row, col) || hasVisited[row][col] || sumRow + SumCol > k) {
            return 0;
        }
        hasVisited[row][col] = true;//标记为已访问
        //自己+(自己下方格子可访问的数)+（自己右方格子可访问的格子数），这里求数位和很巧妙
        return 1 + dfs(row + 1, col, (row + 1) % 10 == 0 ? sumRow - 8 : sumRow + 1, SumCol) +
                dfs(row, col + 1, sumRow, (col + 1) % 10 == 0 ? SumCol - 8 : SumCol + 1);
    }

    private boolean outArea(int row, int col) {
        return row >= rows || col >= cols;
    }
}