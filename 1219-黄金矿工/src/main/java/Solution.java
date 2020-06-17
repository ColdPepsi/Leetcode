/**
 * @author WuBiao
 * @date 2020/6/17 22:57
 */
public class Solution {

    private static int Rows;
    private static int Cols;
    private static final int[][] Directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static int CurrentMax;

    public int getMaximumGold(int[][] grid) {
        Rows = grid.length;
        Cols = grid[0].length;
        int res = -1;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (grid[i][j] != 0) {
                    CurrentMax = 0;
                    backTracking(i, j, 0, grid);
                    res = Math.max(res, CurrentMax);
                }
            }
        }
        return res;
    }

    /**
     * @param row        横坐标
     * @param col        纵坐标
     * @param currentSum 当前和
     * @param grid       数组
     * @return void
     * @description 回溯，但是有个缺点，最长路径会走两遍
     * @author WuBiao
     * @date 2020/6/17 22:58
     */
    private void backTracking(int row, int col, int currentSum, int[][] grid) {
        if (!inBorder(row, col) || grid[row][col] == 0) {
            return;
        }
        currentSum += grid[row][col];
        CurrentMax = Math.max(currentSum, CurrentMax);
        int temp = grid[row][col];
        grid[row][col] = 0;//标记为已经访问
        for (int[] direction : Directions) {
            backTracking(row + direction[0], col + direction[1], currentSum, grid);//回溯下一个结点
        }
        grid[row][col] = temp;//恢复现场
    }

    private boolean inBorder(int r, int c) {
        return 0 <= r && r < Rows && 0 <= c && c < Cols;
    }
}
