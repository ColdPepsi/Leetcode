/**
 * @author WuBiao
 * @date 2020/7/5 21:57
 */
public class SolutionDFS {
    private static int ROW;
    private static int COL;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * @param grid 二维数组
     * @return int
     * @description DFS解法
     * @author WuBiao
     * @date 2020/7/5 22:00
     */
    public int maxDistance(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        int oneTest = 1;
        int zeroTest = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = -1;
                }
                oneTest &= grid[i][j];//与所有数字进行与运算
                zeroTest |= grid[i][j];//所有数进行或运算
            }
        }
        if (oneTest == 1 || zeroTest == 0) {//说明全0或者全1
            return -1;
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 0) {//从陆地开始dfs
                    DFS(grid, i, j);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                max = Math.max(max, grid[i][j]);//取最大值
            }
        }
        return max;
    }

    /**
     * @param grid 二维数组
     * @param row  横坐标
     * @param col  纵坐标
     * @return void
     * @description DFS
     * @author WuBiao
     * @date 2020/7/5 21:58
     */
    private void DFS(int[][] grid, int row, int col) {
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (inArea(nextRow, nextCol) &&
                    (grid[nextRow][nextCol] > grid[row][col] + 1 || grid[nextRow][nextCol] == -1)) {
                //如果一个结点没有访问过，或者该结点的层数不是最优解
                grid[nextRow][nextCol] = grid[row][col] + 1;
                DFS(grid, nextRow, nextCol);
            }
        }
    }

    /**
     * @param row 横坐标
     * @param col 纵坐标
     * @return boolean
     * @description 判断一个点是否在界内
     * @author WuBiao
     * @date 2020/7/5 21:58
     */
    private boolean inArea(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL;
    }
}
