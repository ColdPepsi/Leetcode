/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月20日 13:54:17
 */
public class Solution {

    private static final int[][] Directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    private char[][] grid;
    private String word;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        this.word = word;
        grid = board;
        rows = board.length;
        cols = board[0].length;
        boolean[][] hasVisited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && backTracking(i, j, 0, hasVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(int i, int j, int index, boolean[][] hasVisited) {
        if (index >= word.length()) {
            return true;
        }
        if (!inArea(i, j) || hasVisited[i][j] || grid[i][j] != word.charAt(index)) {
            return false;
        }
        hasVisited[i][j] = true;
        for (int[] direction : Directions) {
            if (backTracking(i + direction[0], j + direction[1], index + 1, hasVisited)) {
                return true;
            }
        }
        hasVisited[i][j] = false;
        return false;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}