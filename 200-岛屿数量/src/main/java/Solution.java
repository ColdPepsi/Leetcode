/**
 * @author WuBiao
 * @date 2020/3/21 18:52
 */
public class Solution {

    int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//方向向量

    /**
     * @param grid
     * @return int
     * @description 相当于求联通分量的数量
     * @author WuBiao
     * @date 2020/3/21 19:00
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;//统计结果+1
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';//标记为已访问
        for (int[] ints : direction) {
            DFS(grid, row + ints[0], col + ints[1]);
        }
    }
}