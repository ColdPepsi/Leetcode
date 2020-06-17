/**
 * @author WuBiao
 * @date 2020/6/17 22:53
 */
public class Solution {

    private static int Rows;
    private static int Cols;

    public int closedIsland(int[][] grid) {
        Rows = grid.length;
        Cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (grid[i][j] == 0 && DFS(i, j, grid)) {//如果该点是孤岛，结果++
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * @param row  当前访问点的横坐标
     * @param col  当前访问点的纵坐标
     * @param grid 数组
     * @return boolean
     * @description 深度优先遍历
     * @author WuBiao
     * @date 2020/6/17 22:54
     */
    private boolean DFS(int row, int col, int[][] grid) {
        if (!inArea(row, col)) {//出界，不是孤岛
            return false;
        }
        if (grid[row][col] == 1) {
            return true;
        }
        grid[row][col] = 1;//标记为已访问
        boolean up = DFS(row - 1, col, grid);//看上面是不是岛屿
        boolean down = DFS(row + 1, col, grid);//下面是不是岛屿
        boolean left = DFS(row, col - 1, grid);//左边是不是岛屿
        boolean right = DFS(row, col + 1, grid);//右边是不是岛屿
        return up && down && left && right;//返回结果
    }

    private boolean inArea(int r, int c) {
        return r >= 0 && r < Rows && c >= 0 && c < Cols;
    }
}
