/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类Solution.java的实现描述：多源点层次遍历
 *
 * @author wubiao21 2020年09月08日 16:29:14
 */
public class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int fresh = 0;//记录新鲜橘子数
        for (int i = 0; i < rows; i++) {//腐烂橘子入队
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * cols + j);//把坐标（i,j）映射成一个数加入到队列中
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {//没有新鲜的，直接输出0
            return 0;
        }
        int ans = 0;
        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                int row = head / cols;
                int col = head % cols;
                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if (inArea(nextRow, nextCol) && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;//标记为腐烂
                        fresh--;
                        queue.offer(nextRow * cols + nextCol);
                    }
                }
            }
        }
        return fresh == 0 ? ans - 1 : -1;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}