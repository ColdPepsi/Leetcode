/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：套用最大1矩阵写法,碰到极值，矩阵会内存溢出
 *
 * @author wubiao21 2020年11月10日 17:01:59
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int max = -1;
        for (int height : heights) {
            max = Math.max(max, height);
        }
        int[][] grid = new int[max][len];
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            for (int j = 0, k = max - 1; j < height; j++, k--) {
                grid[k][i] = 1;
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 1; j < len; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < len; j++) {
                int min = grid[i][j];
                for (int k = i; k >= 0 && min > 0; k--) {
                    min = Math.min(grid[k][j], min);
                    res = Math.max(res, min * (i - k + 1));
                }
            }
        }
        return res;
    }
}