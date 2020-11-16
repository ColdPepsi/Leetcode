/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：一块土地会带来4个周长，但是两个土地接壤就会减去2条边，所以周长为4*土地数-2*接壤边
 *
 * @author wubiao21 2020年11月10日 11:25:46
 */
public class Solution2 {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int lands = 0;
        int border = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    lands++;
                    if (j + 1 < cols && grid[i][j + 1] == 1) {//如果右边和别的土地接壤
                        border++;
                    }
                    if (i + 1 < rows && grid[i + 1][j] == 1) {//如果下边和别的土地接壤
                        border++;
                    }
                }
            }
        }
        return lands * 4 - border * 2;
    }
}

    