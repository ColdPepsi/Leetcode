/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author wubiao21 2020年07月23日 18:39:09
 */
public class Solution {

    private static final int[][] Directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    private int k;
    Set<Integer> hasVisited;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        rows = m;
        cols = n;
        this.k = k;
        hasVisited = new HashSet<>(m * n);
        dfs(0, 0);
        return hasVisited.size();
    }

    private void dfs(int row, int col) {
        if (!valid(row, col)) {
            return;
        }
        int hashCode = hashCode(row, col);
        if (hasVisited.contains(hashCode)) {
            return;
        }
        hasVisited.add(hashCode);
        for (int[] direction : Directions) {
            dfs(row + direction[0], col + direction[1]);
        }
    }

    /**
     * 判断 row，col这个坐标是否合法
     *
     * @param row
     * @param col
     * @return 合法返回true
     */
    private boolean valid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && (getSum(row, col) <= k);
    }

    /**
     * 计算横纵坐标的数位和
     *
     * @param row
     * @param col
     * @return
     */
    private int getSum(int row, int col) {
        return getSum(row) + getSum(col);
    }

    private int hashCode(int row, int col) {
        return row * cols + col;
    }

    /**
     * 计算x的数位和
     *
     * @param x
     * @return
     */
    private int getSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}