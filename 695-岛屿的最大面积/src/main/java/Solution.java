/**
 * @author WuBiao
 * @date 2020/3/21 17:22
 */
public class Solution {

    int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//表示1个点的上下左右4个方向变量

    /**
     * @param grid
     * @return int
     * @description 对每个点进行DFS
     * @author WuBiao
     * @date 2020/3/21 18:09
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, DFS(grid, i, j));//每个点都要进行DFS
            }
        }
        return maxArea;
    }

    /**
     * @param grid
     * @param row
     * @param col
     * @return int
     * @description 以某点为中心DFS，向上下左右搜索，看看最大联通区域
     * @author WuBiao
     * @date 2020/3/21 18:05
     */
    private int DFS(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;//如果越界或者此节点不能访问，则返回0
        }
        int ans = 1;
        grid[row][col] = 0;//表示此节点已经访问过
        for (int[] ints : direction) {
            ans += DFS(grid, row + ints[0], col + ints[1]);
        }
        return ans;
    }
}