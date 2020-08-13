/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 算法思想来自：
 * https://leetcode-cn.com/problems/largest-1-bordered-square/solution/java-si-lu-jian-dan-by-noob-22/
 *
 * @author wubiao21 2020年08月11日 10:32:23
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] left = new int[rows][cols];
        int[][] right = new int[rows][cols];
        int[][] up = new int[rows][cols];
        int[][] down = new int[rows][cols];
        rows--;
        cols--;
        int ret = 0;
        //下面开始初始化4个数组
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    up[i][j] = i > 0 ? up[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int i = rows; i >= 0; i--) {
            for (int j = cols; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = j < cols ? right[i][j + 1] + 1 : 1;
                    down[i][j] = i < rows ? down[i + 1][j] + 1 : 1;
                }
            }
        }
        //下面计算结果
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                int minOne = Integer.min(right[i][j], down[i][j]);
                for (; minOne > 0; minOne--) {
                    int iPoint = i + minOne - 1;
                    int jPoint = j + minOne - 1;
                    int minTwo = Integer.min(left[iPoint][jPoint], up[iPoint][jPoint]);
                    if (minOne <= minTwo) {
                        ret = Math.max(ret, minOne);//minOne是从大到小，找到的第一个就是最大的
                        break;
                    }
                }
            }
        }
        return ret * ret;
    }
}